package com.university.booking_university_project.modules.reservation;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class ReservationRepositoryTest {

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private EntityManager entityManager;

  private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();

  /**
   * There is entity in database. Check {@link #prepareEntity()}.
   *
   * <p>This test checks cases when (new reservation on the left, existing reservation on the right):
   * <ol>
   *   <li>startDate = endDate</li>
   *   <li>startDate between startDate and endDate</li>
   *   <li>endDate = endDate</li>
   *   <li>endDate between startDate and endDate</li>
   *   <li>dates are the same</li>
   * </ol>
   * */
  @Test
  public void shouldReturnTrueOnReservationOverLay() {
    setUpReservationOverLayTest();
    Reservation existingReservation = prepareEntity();
    Reservation startDateEqualsEndDate = prepareEntity();
    Reservation startDateBetweenStartDateAndEndDate = prepareEntity();
    Reservation endDateBetweenStartDateAndEndDate = prepareEntity();
    Reservation endDatesEqualsStartDate = prepareEntity();
    Reservation datesTheSame = prepareEntity();

    startDateEqualsEndDate.setStartDate(existingReservation.getEndDate());
    startDateEqualsEndDate.setEndDate(Timestamp.valueOf(existingReservation.getEndDate().toLocalDateTime().plusDays(1)));
    startDateBetweenStartDateAndEndDate.setStartDate(Timestamp.valueOf(existingReservation.getEndDate().toLocalDateTime().minusSeconds(1)));
    startDateBetweenStartDateAndEndDate.setEndDate(Timestamp.valueOf(existingReservation.getEndDate().toLocalDateTime().plusDays(1)));
    endDateBetweenStartDateAndEndDate.setEndDate(Timestamp.valueOf(existingReservation.getEndDate().toLocalDateTime().minusSeconds(1)));
    endDateBetweenStartDateAndEndDate.setStartDate(Timestamp.valueOf(existingReservation.getStartDate().toLocalDateTime().minusDays(1)));
    endDatesEqualsStartDate.setEndDate(existingReservation.getStartDate());
    endDatesEqualsStartDate.setStartDate(Timestamp.valueOf(existingReservation.getStartDate().toLocalDateTime().minusDays(1)));

    assertTrue(reservationRepository.isReservationExistsForApartmentInDates(startDateEqualsEndDate.getApartment().getId(), startDateEqualsEndDate.getStartDate(), startDateEqualsEndDate.getEndDate()));
    assertTrue(reservationRepository.isReservationExistsForApartmentInDates(startDateBetweenStartDateAndEndDate.getApartment().getId(), startDateBetweenStartDateAndEndDate.getStartDate(), startDateBetweenStartDateAndEndDate.getEndDate()));
    assertTrue(reservationRepository.isReservationExistsForApartmentInDates(endDateBetweenStartDateAndEndDate.getApartment().getId(), endDateBetweenStartDateAndEndDate.getStartDate(), endDateBetweenStartDateAndEndDate.getEndDate()));
    assertTrue(reservationRepository.isReservationExistsForApartmentInDates(endDatesEqualsStartDate.getApartment().getId(), endDatesEqualsStartDate.getStartDate(), endDatesEqualsStartDate.getEndDate()));
    assertTrue(reservationRepository.isReservationExistsForApartmentInDates(datesTheSame.getApartment().getId(), datesTheSame.getStartDate(), datesTheSame.getEndDate()));
  }

  /**
   * There is entity in database. Check {@link #prepareEntity()}.
   *
   * <p>This test checks cases when:
   * <ol>
   *   <li>New reservation dates are before</li>
   *   <li>New reservation dates are after</li>
   * </ol>
   * */
  @Test
  public void shouldReturnFalseIfNoReservationOverlayCaused() {
    setUpReservationOverLayTest();

    Reservation reservationBefore = prepareEntity();
    Reservation reservationAfter = prepareEntity();

    reservationBefore.setStartDate(Timestamp.valueOf(reservationBefore.getStartDate().toLocalDateTime().minusDays(8)));
    reservationBefore.setEndDate(Timestamp.valueOf(reservationBefore.getEndDate().toLocalDateTime().minusDays(8)));
    reservationAfter.setStartDate(Timestamp.valueOf(reservationAfter.getStartDate().toLocalDateTime().plusDays(8)));
    reservationAfter.setEndDate(Timestamp.valueOf(reservationAfter.getEndDate().toLocalDateTime().plusDays(8)));
  }

  private void setUpReservationOverLayTest() {
    entityManager.createNativeQuery("ALTER TABLE public.reservation DISABLE TRIGGER ALL;");

    Reservation reservation = prepareEntity();
    reservationRepository.save(reservation);
  }

  /**
   * Creates reservation that lasts 1 week from now.
   * */
  @Singleton
  private Reservation prepareEntity() {
    Reservation reservation = new Reservation();
    Apartment apartment = new Apartment();
    User user = new User();
    apartment.setId(1);
    user.setId(1);
    reservation.setPrice(1);
    reservation.setReservationStatus(ReservationStatus.ACTIVE);
    reservation.setApartment(apartment);
    reservation.setUser(user);
    reservation.setNumberOfPeople(1);

    reservation.setStartDate(Timestamp.valueOf(LOCAL_DATE_TIME));
    reservation.setEndDate(Timestamp.valueOf(LOCAL_DATE_TIME.plusDays(7)));
    return reservation;
  }
}
