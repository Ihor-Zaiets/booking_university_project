package com.university.booking_university_project.modules.apartment;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.testUtils.TestUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ApartmentServiceImplTest
    implements BaseServiceTest<Apartment, Integer, ApartmentServiceImpl> {

  @InjectMocks
  private ApartmentServiceImpl apartmentService;

  @Mock
  private ApartmentRepository apartmentRepository;

  private TestUtils testUtils;

  public static final int TEST_NUMBER_OF_ROOMS = 3;
  public static final double TEST_SQUARE = 100.0;
  public static final double TEST_RENT_PRICE = 1500.0;
  public static final int TEST_FLOOR = 2;
  public static final String TEST_DESCRIPTION = "Apartment";
  public static final int TEST_NUMBER_OF_DOUBLE_BEDS = 2;
  public static final int TEST_NUMBER_OF_SINGLE_BEDS = 1;



  @Override
  public ApartmentServiceImpl createService() {
    Apartment entity = createEntity();
    Apartment entity1 = createEntity();

    when(entity.getId()).thenReturn(0);
    when(entity1.getId()).thenReturn(1);
    when(apartmentRepository.saveAll(anyCollection())).thenReturn(List.of(entity, entity1));
    return apartmentService;
  }

  @Override
  public Apartment createEntity() {
    Apartment apartment = mock(Apartment.class);
    when(apartment.getId()).thenReturn(null);
    return apartment;
  }
}
