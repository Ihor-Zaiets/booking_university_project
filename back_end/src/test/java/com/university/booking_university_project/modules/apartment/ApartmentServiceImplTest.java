package com.university.booking_university_project.modules.apartment;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.testUtils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApartmentServiceImplTest
    implements BaseServiceTest<Apartment, Integer, ApartmentServiceImpl> {

  private final ApartmentRepository apartmentRepository;

  private final TestUtils testUtils;

  public static final int TEST_NUMBER_OF_ROOMS = 3;
  public static final double TEST_SQUARE = 100.0;
  public static final double TEST_RENT_PRICE = 1500.0;
  public static final int TEST_FLOOR = 2;
  public static final String TEST_DESCRIPTION = "Apartment";
  public static final int TEST_NUMBER_OF_DOUBLE_BEDS = 2;
  public static final int TEST_NUMBER_OF_SINGLE_BEDS = 1;

  @Autowired
  public ApartmentServiceImplTest(ApartmentRepository apartmentRepository, TestUtils testUtils) {
    this.apartmentRepository = apartmentRepository;
    this.testUtils = testUtils;
  }

  @Override
  public ApartmentServiceImpl createService() {
    return new ApartmentServiceImpl(apartmentRepository);
  }

  @Override
  public Apartment createEntity() {
    return testUtils.createApartmentEntity(
        TEST_NUMBER_OF_ROOMS,
        TEST_SQUARE,
        TEST_RENT_PRICE,
        TEST_FLOOR,
        TEST_DESCRIPTION,
        TEST_NUMBER_OF_DOUBLE_BEDS,
        TEST_NUMBER_OF_SINGLE_BEDS);
  }
}
