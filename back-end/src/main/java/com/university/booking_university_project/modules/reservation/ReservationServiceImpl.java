package com.university.booking_university_project.modules.reservation;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ResourceNotFoundException;
import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.modules.apartment.ApartmentService;
import com.university.booking_university_project.modules.reservation.dto.ReservationCreationDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationRequestDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationUpdateDTO;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import com.university.booking_university_project.modules.sender.EmailSenderService;
import com.university.booking_university_project.modules.user.UserService;
import com.university.booking_university_project.modules.user.dto.UserCreateDTO;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.validators.Validation;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final UserService userService;

    private final Mapper mapper;

    private final EmailSenderService emailSenderService;

    private final ApartmentService apartmentService;

    public static final String RESERVATION_EMAIL_TITLE = "Szczegóły rezerwacji";

    @Autowired
    public ReservationServiceImpl(
            ReservationRepository reservationRepository,
            UserService userService,
            Mapper mapper,
            EmailSenderService emailSenderService,
            ApartmentService apartmentService
    ) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.mapper = mapper;
        this.emailSenderService = emailSenderService;
        this.apartmentService = apartmentService;
    }

    @Override
    public List<Reservation> saveAll(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public void deleteAll(List<Reservation> reservations) {
        reservationRepository.deleteAll(reservations);
    }

    @Override
    public void deleteAllByIds(List<Integer> ids) {
        reservationRepository.deleteAllById(ids);
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<ReservationDTO> createReservations(List<ReservationCreationDTO> reservationCreationDTOList) {
        List<Reservation> reservations = new ArrayList<>();
        for (
            ReservationCreationDTO reservationCreationDTO : reservationCreationDTOList
        ) {
            validateReservation(reservationCreationDTO);
            reservations.add(mapper.map(reservationCreationDTO, Reservation.class));
        }
        reservations = reservationRepository.saveAll(reservations);
        return reservations.stream()
                .map(reservation -> mapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());
    }

    private <DTO extends ReservationUpdateDTO> void validateReservation(DTO reservationCreationDTO) {
        validateDates(reservationCreationDTO.getStartDate(), reservationCreationDTO.getEndDate());
        Validation.validateObjectNullOrEmpty(reservationCreationDTO.getUserId());
        Validation.validateObjectNullOrEmpty(reservationCreationDTO.getApartmentId());
        Validation.validateNumberMoreOrEquals0(reservationCreationDTO.getNumberOfPeople());
        validateReservationOverlay(reservationCreationDTO);
    }

    private <DTO extends ReservationUpdateDTO> void validateReservationOverlay(DTO reservationCreationDTO) {
        if (reservationRepository.isReservationExistsForApartmentInDates(
                reservationCreationDTO.getApartmentId(),
                reservationCreationDTO.getStartDate(),
                reservationCreationDTO.getEndDate()
        )) throw new ValidationException(ExceptionMessage.RESERVATION_OVERLAY);
    }

    private void validateDates(Timestamp startDate, Timestamp endDate) {
        if (startDate == null || endDate == null) throw new ValidationException(
                ExceptionMessage.START_DATE_OR_END_DATE_IS_NULL
        );
        if (startDate.after(endDate)) throw new ValidationException(ExceptionMessage.END_DATE_BEFORE_START_DATE);
        if (startDate.equals(endDate)) throw new ValidationException(ExceptionMessage.START_DATE_EQUALS_END_DATE);
    }

    @Override
    public List<ReservationDTO> findAllDTO() {
        return reservationRepository.findAll()
                .stream()
                .map(entity -> mapper.map(entity, ReservationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationDTO> editReservations(List<ReservationUpdateDTO> reservationUpdateDTOList) {
        List<Reservation> reservations = new ArrayList<>();
        for (
            ReservationUpdateDTO reservationUpdateDTO : reservationUpdateDTOList
        ) {
            validateReservation(reservationUpdateDTO);
            reservations.add(mapper.map(reservationUpdateDTO, Reservation.class));
        }
        reservations = reservationRepository.saveAll(reservations);
        return reservations.stream()
                .map(reservation -> mapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO makeReservation(ReservationRequestDTO reservationRequestDTO) {
        checkReservationUser(reservationRequestDTO);
        if (reservationRequestDTO.getNumberOfPeople() == null) reservationRequestDTO.setNumberOfPeople(1);
        validateReservation(reservationRequestDTO);
        reservationRequestDTO.setPrice(
                calculatePrice(
                        reservationRequestDTO.getPrice(),
                        reservationRequestDTO.getStartDate(),
                        reservationRequestDTO.getEndDate()
                )
        );
        Reservation reservation = this.save(mapper.map(reservationRequestDTO, Reservation.class));
        sendEmailIfPossible(reservationRequestDTO);
        return mapper.map(reservation, ReservationDTO.class);
    }

    private void sendEmailIfPossible(ReservationRequestDTO reservationRequestDTO) {
        if (reservationRequestDTO.getUserEmail() != null && reservationRequestDTO.getUserEmail()
                .endsWith("@gmail.com")) {
            Apartment apartment = apartmentService.findById(reservationRequestDTO.getApartmentId())
                    .orElseThrow(ResourceNotFoundException::new);
            String emailContent = new StringBuilder().append("Witamy. Przesyłamy Państwu szczególy rezerwacji.")
                    .append("\n")
                    .append("\n")
                    .append("Adres hotelu: ")
                    .append(apartment.getAddress())
                    .append("\n")
                    .append("Początek rezerwacji: ")
                    .append(reservationRequestDTO.getStartDate().toLocalDateTime().toLocalDate())
                    .append(" o 14:00.")
                    .append("\n")
                    .append("Koniec rezerwacji: ")
                    .append(reservationRequestDTO.getEndDate().toLocalDateTime().toLocalDate())
                    .append(" o 14:00.")
                    .append("\n")
                    .append("Cena: ")
                    .append(reservationRequestDTO.getPrice())
                    .append(" zl ")
                    .append("\n")
                    .toString();
            emailSenderService.send(reservationRequestDTO.getUserEmail(), RESERVATION_EMAIL_TITLE, emailContent);
        }
    }

    private Integer calculatePrice(Integer price, Timestamp startDate, Timestamp endDate) {
        return Math.toIntExact(ChronoUnit.DAYS.between(startDate.toLocalDateTime(), endDate.toLocalDateTime()) * price);
    }

    private void checkReservationUser(ReservationRequestDTO reservationRequestDTO) {
        if (!reservationRequestDTO.getIsUserLogged()) {
            UserCreateDTO userCreateDTO = new UserCreateDTO();
            userCreateDTO.setPhone(reservationRequestDTO.getUserPhoneNumber());
            userCreateDTO.setFirstname(reservationRequestDTO.getUserFirstName());
            List<UserDTO> users = userService.createUsers(List.of(userCreateDTO));
            reservationRequestDTO.setUserId(users.get(0).getId());
        }
    }
}
