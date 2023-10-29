package com.university.booking_university_project.modules.reservation;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import com.university.booking_university_project.modules.apartment.ApartmentServiceImplTest;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import com.university.booking_university_project.modules.user.UserServiceImplTest;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import com.university.booking_university_project.testUtils.TestUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class ReservationServiceImplTest
    implements BaseServiceTest<Reservation, Integer, ReservationServiceImpl> {

  private final ReservationRepository reservationRepository;

  private final ApartmentRepository apartmentRepository;

  private final UserRepository userRepository;

  private final TestUtils testUtils;

  private static final Timestamp TEST_START_DATE = Timestamp.valueOf("2023-01-01 12:00:00");
  private static final Timestamp TEST_END_DATE = Timestamp.valueOf("2023-01-03 12:00:00");
  private static final int TEST_NUMBER_OF_PEOPLE = 4;
  private static final ReservationStatus TEST_RESERVATION_STATUS = ReservationStatus.ACTIVE;
  private static final Integer TEST_RESERVATION_PRICE = 1000;

  @Autowired
  public ReservationServiceImplTest(
      ReservationRepository reservationRepository,
      ApartmentRepository apartmentRepository,
      UserRepository userRepository,
      TestUtils testUtils) {
    this.reservationRepository = reservationRepository;
    this.apartmentRepository = apartmentRepository;
    this.userRepository = userRepository;
    this.testUtils = testUtils;
  }

  @Override
  public ReservationServiceImpl createService() {
    return new ReservationServiceImpl(reservationRepository);
  }

  @Override
  public Reservation createEntity() {
    Reservation reservation = new Reservation();
    reservation.setApartment(createApartment());
    reservation.setUser(createUser());
    reservation.setStart_date(TEST_START_DATE);
    reservation.setEnd_date(TEST_END_DATE);
    reservation.setNumberOfPeople(TEST_NUMBER_OF_PEOPLE);
    reservation.setReservationStatus(TEST_RESERVATION_STATUS);
    reservation.setPrice(TEST_RESERVATION_PRICE);
    return reservation;
  }

  private Apartment createApartment() {
    return apartmentRepository.save(
        testUtils.createApartmentEntity(
            ApartmentServiceImplTest.TEST_NUMBER_OF_ROOMS,
            ApartmentServiceImplTest.TEST_SQUARE,
            ApartmentServiceImplTest.TEST_RENT_PRICE,
            ApartmentServiceImplTest.TEST_FLOOR,
            ApartmentServiceImplTest.TEST_DESCRIPTION,
            ApartmentServiceImplTest.TEST_NUMBER_OF_DOUBLE_BEDS,
            ApartmentServiceImplTest.TEST_NUMBER_OF_SINGLE_BEDS));
  }

  private User createUser() {
    return userRepository.save(
        testUtils.createUserEntity(
            UserServiceImplTest.TEST_USER_NAME,
            UserServiceImplTest.TEST_USER_SURNAME,
            UserServiceImplTest.TEST_USER_EMAIL,
            UserServiceImplTest.TEST_USER_PHONE,
            UserServiceImplTest.TEST_USER_ADDRESS));
  }
}
