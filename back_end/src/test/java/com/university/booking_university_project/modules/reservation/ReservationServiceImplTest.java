package com.university.booking_university_project.modules.reservation;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class ReservationServiceImplTest implements BaseServiceTest<Reservation, Integer, ReservationServiceImpl> {

  private final ReservationRepository reservationRepository;

  private static final Timestamp TEST_START_DATE = Timestamp.valueOf("2023-01-01 12:00:00");
  private static final Timestamp TEST_END_DATE = Timestamp.valueOf("2023-01-03 12:00:00");
  private static final int TEST_NUMBER_OF_PEOPLE = 4;
  private static final ReservationStatus TEST_RESERVATION_STATUS = ReservationStatus.ACTIVE;


  @Autowired
  public ReservationServiceImplTest(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public ReservationServiceImpl createService() {
    return new ReservationServiceImpl(reservationRepository);
  }

  @Override
  public Reservation createEntity() {
    Reservation reservation = new Reservation();
    reservation.setApartment(new Apartment()); // Создайте объект Apartment или используйте mock
    reservation.setUser(new User()); // Создайте объект User или используйте mock
    reservation.setStart_date(TEST_START_DATE);
    reservation.setEnd_date(TEST_END_DATE);
    reservation.setNumberOfPeople(TEST_NUMBER_OF_PEOPLE);
    reservation.setReservationStatus(TEST_RESERVATION_STATUS);
    return reservation;
  }
}
