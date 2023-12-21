package com.university.booking_university_project.modules.role.repository;

import com.university.booking_university_project.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByName(String name);

    boolean existsByName(String name);

    @Query(value = "insert into public.user_role(user_id, role_id) VALUES (:userId, :roleId)", nativeQuery = true)
    void assignRoleToUser(Integer userId, Integer roleId);

    @Query(value = "delete from public.user_role ur where ur.user_id = :userId and ur.role_id = :roleId", nativeQuery = true)
    void unassignRoleFromUser(Integer userId, Integer roleId);
}
