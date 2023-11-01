package com.university.booking_university_project.modules.reservation;

import com.university.booking_university_project.jpa.entity.Reservation;
import com.university.booking_university_project.modules.EntityService;
import com.university.booking_university_project.modules.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl
    extends EntityService<Reservation, Integer, ReservationRepository>
    implements ReservationService {

}
