package com.university.booking_university_project.modules.apartment;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.apartment.dto.ApartmentCreationDTO;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ApartmentServiceImplTest {

  @InjectMocks
  private ApartmentServiceImpl apartmentService;

  @Mock
  private ApartmentRepository apartmentRepository;

  @Mock
  private Mapper mapper;

  public static final String DTO_MOCK_DESCRIPTION_FIELD = "DTO_MOCK_DESCRIPTION_FIELD";
  public static final Integer DTO_MOCK_FLOOR_FIELD = 1;
  public static final Double DTO_MOCK_SQUARE_FIELD = 1.0;
  public static final Double DTO_MOCK_RENT_PRICE_FIELD = 1.0;
  public static final Integer DTO_MOCK_NUMBER_OF_ROOMS_FIELD = 1;
  public static final Integer DTO_MOCK_NUMBER_OF_DOUBLE_BEDS_FIELD = 1;
  public static final Integer DTO_MOCK_NUMBER_OF_SINGLE_BEDS_FIELD = 1;

  @Test
  public void shouldThrowIfFloorFieldIsLessThen1() {
    ApartmentCreationDTO apartmentCreationDTO = createMock();

    when(apartmentCreationDTO.getFloor()).thenReturn(0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);

    when(apartmentCreationDTO.getFloor()).thenReturn(-1);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldThrowIfSquareFieldIsLessThen1() {
    ApartmentCreationDTO apartmentCreationDTO = createMock();

    when(apartmentCreationDTO.getSquare()).thenReturn(0.0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);

    when(apartmentCreationDTO.getSquare()).thenReturn(-1.0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldThrowIfRentPriceFieldIsLessThen1() {
    ApartmentCreationDTO apartmentCreationDTO = createMock();

    when(apartmentCreationDTO.getRentPrice()).thenReturn(0.0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);

    when(apartmentCreationDTO.getRentPrice()).thenReturn(-1.0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldThrowIfNumberOfRoomsFieldIsLessThen1() {
    ApartmentCreationDTO apartmentCreationDTO = createMock();

    when(apartmentCreationDTO.getNumberOfRooms()).thenReturn(0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);

    when(apartmentCreationDTO.getNumberOfRooms()).thenReturn(-1);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldThrowIfNumberOfDoubleBedsFieldIsLessThen1() {
    ApartmentCreationDTO apartmentCreationDTO = createMock();

    when(apartmentCreationDTO.getNumberOfDoubleBeds()).thenReturn(0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);

    when(apartmentCreationDTO.getNumberOfDoubleBeds()).thenReturn(-1);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldThrowIfNumberOfSingleBedsIsLessThen1() {
    ApartmentCreationDTO apartmentCreationDTO = createMock();

    when(apartmentCreationDTO.getNumberOfSingleBeds()).thenReturn(0);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);

    when(apartmentCreationDTO.getNumberOfSingleBeds()).thenReturn(-1);
    assertThrows(ValidationException.class, () -> apartmentService.createApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
    assertThrows(ValidationException.class, () -> apartmentService.editApartments(List.of(apartmentCreationDTO)), ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

  @Test
  public void shouldNotThrow() {
    ApartmentCreationDTO apartmentCreationDTO = createMock();
    when(mapper.map(apartmentCreationDTO, Apartment.class)).thenReturn(mock(Apartment.class));
    when(apartmentRepository.saveAll(any())).thenReturn(List.of(mock(Apartment.class)));
    assertDoesNotThrow(() -> apartmentService.createApartments(List.of(apartmentCreationDTO)));
  }

  private ApartmentCreationDTO createMock() {
    ApartmentCreationDTO apartmentCreationDTO = mock(ApartmentCreationDTO.class);
    when(apartmentCreationDTO.getDescription()).thenReturn(DTO_MOCK_DESCRIPTION_FIELD);
    when(apartmentCreationDTO.getFloor()).thenReturn(DTO_MOCK_FLOOR_FIELD);
    when(apartmentCreationDTO.getSquare()).thenReturn(DTO_MOCK_SQUARE_FIELD);
    when(apartmentCreationDTO.getRentPrice()).thenReturn(DTO_MOCK_RENT_PRICE_FIELD);
    when(apartmentCreationDTO.getNumberOfRooms()).thenReturn(DTO_MOCK_NUMBER_OF_ROOMS_FIELD);
    when(apartmentCreationDTO.getNumberOfDoubleBeds()).thenReturn(DTO_MOCK_NUMBER_OF_DOUBLE_BEDS_FIELD);
    when(apartmentCreationDTO.getNumberOfSingleBeds()).thenReturn(DTO_MOCK_NUMBER_OF_SINGLE_BEDS_FIELD);
    return apartmentCreationDTO;
  }
}
