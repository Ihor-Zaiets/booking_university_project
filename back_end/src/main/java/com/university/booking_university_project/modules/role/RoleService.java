package com.university.booking_university_project.modules.role;

import com.university.booking_university_project.jpa.entity.Role;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.BaseService;
import com.university.booking_university_project.modules.role.dto.RoleCreationDTO;
import com.university.booking_university_project.modules.role.dto.RoleDTO;
import com.university.booking_university_project.modules.role.dto.UserRoleDTO;

import java.util.List;

public interface RoleService extends BaseService<Role, Integer> {
  List<RoleDTO> createRoles(RoleCreationDTO roleCreationDTO);

  List<RoleDTO> findAllRolesDTO();

  List<RoleDTO> editRoles(RoleCreationDTO roleCreationDTO);

  void grantRoles(List<UserRoleDTO> userRoleDTOList);

  void revokeRoles(List<UserRoleDTO> userRoleDTOList);

  void assignDefaultRole(User user);
}
