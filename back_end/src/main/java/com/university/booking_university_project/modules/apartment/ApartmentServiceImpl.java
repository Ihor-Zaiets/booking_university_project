package com.university.booking_university_project.modules.apartment;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.modules.EntityService;
import com.university.booking_university_project.modules.apartment.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentServiceImpl extends EntityService<Apartment, Integer, ApartmentRepository>
    implements ApartmentService {
}
