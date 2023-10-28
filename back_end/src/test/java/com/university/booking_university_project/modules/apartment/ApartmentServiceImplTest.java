package com.university.booking_university_project.modules.apartment;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApartmentServiceImplTest
    implements BaseServiceTest<Apartment, Integer, ApartmentServiceImpl> {

  private final ApartmentRepository apartmentRepository;

  private static final int TEST_NUMBER_OF_ROOMS = 3;
  private static final double TEST_SQUARE = 100.0;
  private static final double TEST_RENT_PRICE = 1500.0;
  private static final int TEST_FLOOR = 2;
  private static final String TEST_DESCRIPTION = "Просторная трехкомнатная квартира.";
  private static final int TEST_NUMBER_OF_DOUBLE_BEDS = 2;
  private static final int TEST_NUMBER_OF_SINGLE_BEDS = 1;

  @Autowired
  public ApartmentServiceImplTest(ApartmentRepository apartmentRepository) {
    this.apartmentRepository = apartmentRepository;
  }

  @Override
  public ApartmentServiceImpl createService() {
    return new ApartmentServiceImpl(apartmentRepository);
  }

  @Override
  public Apartment createEntity() {
    Apartment apartment = new Apartment();
    apartment.setNumberOfRooms(TEST_NUMBER_OF_ROOMS);
    apartment.setSquare(TEST_SQUARE);
    apartment.setRentPrice(TEST_RENT_PRICE);
    apartment.setFloor(TEST_FLOOR);
    apartment.setDescription(TEST_DESCRIPTION);
    apartment.setNumberOfDoubleBeds(TEST_NUMBER_OF_DOUBLE_BEDS);
    apartment.setNumberOfSingleBeds(TEST_NUMBER_OF_SINGLE_BEDS);
    return apartment;
  }
}
