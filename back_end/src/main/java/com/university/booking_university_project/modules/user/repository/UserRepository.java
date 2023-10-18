package com.university.booking_university_project.modules.user.repository;

import com.university.booking_university_project.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
