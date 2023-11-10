package com.university.booking_university_project.modules.role.repository;

import com.university.booking_university_project.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Role findRoleByName(String name);
}
