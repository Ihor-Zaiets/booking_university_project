package com.university.booking_university_project.modules.reservation;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import jakarta.persistence.EntityManager;
import java.sql.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReservationServiceImplBaseTest implements BaseServiceTest<Reservation, Integer, ReservationServiceImpl> {

    private final ReservationRepository reservationRepository;

    private final EntityManager entityManager;

    private final Mapper mapper;

    private static final Timestamp TEST_START_DATE = Timestamp.valueOf("2023-01-01 12:00:00");
    private static final Timestamp TEST_END_DATE = Timestamp.valueOf("2023-01-03 12:00:00");
    private static final int TEST_NUMBER_OF_PEOPLE = 4;
    private static final ReservationStatus TEST_RESERVATION_STATUS = ReservationStatus.ACTIVE;
    private static final Integer TEST_RESERVATION_PRICE = 1000;

    @Autowired
    public ReservationServiceImplBaseTest(
            ReservationRepository reservationRepository,
            EntityManager entityManager,
            Mapper mapper
    ) {
        this.reservationRepository = reservationRepository;
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @Override
    public ReservationServiceImpl createService() {
        return new ReservationServiceImpl(reservationRepository, mapper);
    }

    @Override
    public Reservation createEntity() {
        Apartment apartment = new Apartment();
        User user = new User();
        apartment.setId(0);
        user.setId(0);

        Reservation reservation = new Reservation();
        reservation.setApartment(apartment);
        reservation.setUser(user);
        reservation.setStartDate(TEST_START_DATE);
        reservation.setEndDate(TEST_END_DATE);
        reservation.setNumberOfPeople(TEST_NUMBER_OF_PEOPLE);
        reservation.setReservationStatus(TEST_RESERVATION_STATUS);
        reservation.setPrice(TEST_RESERVATION_PRICE);
        return reservation;
    }

    @BeforeEach
    public void setUp() {
        Logger logger = LoggerFactory.getLogger(ReservationServiceImplBaseTest.class);
        logger.info("before each< find me");
        String disableConstraintsQuery = "ALTER TABLE public.reservation DISABLE TRIGGER ALL;";
        entityManager.createNativeQuery(disableConstraintsQuery).executeUpdate();
    }
}
