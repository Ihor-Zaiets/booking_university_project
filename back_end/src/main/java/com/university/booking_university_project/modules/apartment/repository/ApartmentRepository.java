package com.university.booking_university_project.modules.apartment.repository;

import com.university.booking_university_project.jpa.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {}
