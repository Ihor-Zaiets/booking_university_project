package com.university.booking_university_project.modules.reservation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import com.university.booking_university_project.modules.reservation.dto.ReservationCreationDTO;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReservationServiceImplTest {

  @InjectMocks
  private ReservationServiceImpl reservationServiceImpl;

  @Mock
  private ReservationRepository reservationRepository;

  @Test
  public void ShouldThrowIfApartmentIsNull() {
    ReservationCreationDTO reservationCreationDTO = createDTOMock();
    when(reservationCreationDTO.getApartmentId()).thenReturn(null);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.createReservations(List.of(reservationCreationDTO)), ExceptionMessage.FIELD_NULL_OR_EMPTY_VALIDATION_MESSAGE);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.editReservations(List.of(reservationCreationDTO)), ExceptionMessage.FIELD_NULL_OR_EMPTY_VALIDATION_MESSAGE);
  }

  @Test
  public void ShouldThrowIfUserIsNull() {
    ReservationCreationDTO reservationCreationDTO = createDTOMock();
    when(reservationCreationDTO.getUserId()).thenReturn(null);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.createReservations(List.of(reservationCreationDTO)), ExceptionMessage.FIELD_NULL_OR_EMPTY_VALIDATION_MESSAGE);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.editReservations(List.of(reservationCreationDTO)), ExceptionMessage.FIELD_NULL_OR_EMPTY_VALIDATION_MESSAGE);
  }

  @Test
  public void shouldThrowIfNumberOfPeopleFieldIsLessThen0() {
    ReservationCreationDTO reservationCreationDTO = createDTOMock();

    when(reservationCreationDTO.getNumberOfPeople()).thenReturn(-1);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.createReservations(List.of(reservationCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.editReservations(List.of(reservationCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldThrowIfPriceFieldIsLessThen0() {
    ReservationCreationDTO reservationCreationDTO = createDTOMock();

    when(reservationCreationDTO.getPrice()).thenReturn(-1);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.createReservations(List.of(reservationCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.editReservations(List.of(reservationCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldThrowIfStartDateLaterThenEndDate() {
    ReservationCreationDTO reservationCreationDTO = createDTOMock();

    when(reservationCreationDTO.getStartDate()).thenReturn(Timestamp.valueOf(LocalDateTime.now()));
    when(reservationCreationDTO.getEndDate()).thenReturn(Timestamp.valueOf(LocalDateTime.now().minusSeconds(1)));

    assertThrows(ValidationException.class, () -> reservationServiceImpl.createReservations(List.of(reservationCreationDTO)), ExceptionMessage.END_DATE_BEFORE_START_DATE);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.editReservations(List.of(reservationCreationDTO)), ExceptionMessage.END_DATE_BEFORE_START_DATE);
  }

  @Test
  public void shouldThrowIfReservationForApartmentOnThatTimeAlreadyExists() {
    ReservationCreationDTO reservationCreationDTO = createDTOMock();

    when(reservationRepository.isReservationExistsForApartmentInDates(
            reservationCreationDTO.getApartmentId(),
            reservationCreationDTO.getStartDate(),
            reservationCreationDTO.getEndDate()))
            .thenReturn(true);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.createReservations(List.of(reservationCreationDTO)), ExceptionMessage.RESERVATION_OVERLAY);
    assertThrows(ValidationException.class, () -> reservationServiceImpl.editReservations(List.of(reservationCreationDTO)), ExceptionMessage.RESERVATION_OVERLAY);
  }
  
  @Test
  public void shouldNotThrow() {
    ReservationCreationDTO reservationCreationDTO = createDTOMock();
    assertDoesNotThrow(() -> reservationServiceImpl.createReservations(List.of(reservationCreationDTO)));
    assertDoesNotThrow(() -> reservationServiceImpl.editReservations(List.of(reservationCreationDTO)));
  }

  private ReservationCreationDTO createDTOMock() {
    ReservationCreationDTO reservationCreationDTO = mock(ReservationCreationDTO.class);
    when(reservationCreationDTO.getPrice()).thenReturn(1);
    when(reservationCreationDTO.getStartDate()).thenReturn(Timestamp.valueOf(LocalDateTime.now()));
    when(reservationCreationDTO.getEndDate()).thenReturn(Timestamp.valueOf(LocalDateTime.now().plusDays(7)));
    when(reservationCreationDTO.getApartmentId()).thenReturn(1);
    when(reservationCreationDTO.getUserId()).thenReturn(1);
    when(reservationCreationDTO.getReservationStatus()).thenReturn(ReservationStatus.ACTIVE);
    return reservationCreationDTO;
  }
}
