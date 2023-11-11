package com.university.booking_university_project.modules.reservation;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.modules.reservation.dto.ReservationCreationDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationDTO;
import com.university.booking_university_project.modules.reservation.dto.ReservationUpdateDTO;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import com.university.booking_university_project.validators.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

  private final ReservationRepository reservationRepository;

  private final Mapper mapper;

  @Autowired
  public ReservationServiceImpl(ReservationRepository reservationRepository, Mapper mapper) {
    this.reservationRepository = reservationRepository;
    this.mapper = mapper;
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
    for (ReservationCreationDTO reservationCreationDTO : reservationCreationDTOList) {
      validateReservation(reservationCreationDTO);
      reservations.add(mapper.map(reservationCreationDTO, Reservation.class));
    }
    reservations = reservationRepository.saveAll(reservations);
    return reservations.stream().map(reservation -> mapper.map(reservation, ReservationDTO.class)).collect(Collectors.toList());
  }

  private <DTO extends ReservationUpdateDTO> void validateReservation(DTO reservationCreationDTO) {
    validateDates(reservationCreationDTO.getStartDate(), reservationCreationDTO.getEndDate());
    Validation.validateStringNullOrEmpty(reservationCreationDTO.getUserId());
    Validation.validateStringNullOrEmpty(reservationCreationDTO.getApartmentId());
    Validation.validateNumberMoreOrEquals0(reservationCreationDTO.getNumberOfPeople());
    Validation.validateNumberMoreOrEquals0(reservationCreationDTO.getPrice());
    validateReservationOverlay(reservationCreationDTO);
  }

  private <DTO extends ReservationUpdateDTO> void validateReservationOverlay(DTO reservationCreationDTO) {
    if (reservationRepository.isReservationExistsForApartmentInDates(
            reservationCreationDTO.getApartmentId(),
            reservationCreationDTO.getStartDate(),
            reservationCreationDTO.getEndDate()))
      throw new ValidationException(ExceptionMessage.RESERVATION_OVERLAY);
  }

  private void validateDates(Timestamp startDate, Timestamp endDate) {
    if (startDate.after(endDate))
      throw new ValidationException(ExceptionMessage.END_DATE_BEFORE_START_DATE);
  }

  @Override
  public List<ReservationDTO> findAllDTO() {
    return reservationRepository.findAll().stream().map(entity -> mapper.map(entity, ReservationDTO.class)).collect(Collectors.toList());
  }

  @Override
  public List<ReservationDTO> editReservations(List<ReservationUpdateDTO> reservationUpdateDTOList) {
    List<Reservation> reservations = new ArrayList<>();
    for (ReservationUpdateDTO reservationUpdateDTO : reservationUpdateDTOList) {
      validateReservation(reservationUpdateDTO);
      reservations.add(mapper.map(reservationUpdateDTO, Reservation.class));
    }
    reservations = reservationRepository.saveAll(reservations);
    return reservations.stream().map(reservation -> mapper.map(reservation, ReservationDTO.class)).collect(Collectors.toList());
  }
}
