package com.university.booking_university_project.modules.baseService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseServiceTestRepository extends JpaRepository<BaseServiceTestEntity, Integer> {
}
