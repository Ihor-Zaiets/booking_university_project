package com.university.booking_university_project.modules.role;

import com.university.booking_university_project.jpa.entity.Role;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.role.dto.RoleCreationDTO;
import com.university.booking_university_project.modules.role.dto.RoleDTO;
import com.university.booking_university_project.modules.role.dto.UserRoleDTO;
import com.university.booking_university_project.modules.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  public static final String DEFAULT_ROLE_NAME = "USER";

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public List<Role> saveAll(List<Role> roles) {
    return roleRepository.saveAll(roles);
  }

  @Override
  public void deleteAll(List<Role> roles) {
    roleRepository.deleteAll(roles);
  }

  @Override
  public void deleteAllByIds(List<Integer> ids) {
    roleRepository.deleteAllById(ids);
  }

  @Override
  public Optional<Role> findById(Integer id) {
    return roleRepository.findById(id);
  }

  @Override
  public List<RoleDTO> createRoles(RoleCreationDTO roleCreationDTO) {
    return null;
  }

  @Override
  public List<RoleDTO> findAllRolesDTO() {
    return null;
  }

  @Override
  public List<RoleDTO> editRoles(RoleCreationDTO roleCreationDTO) {
    return null;
  }

  @Override
  public void grantRoles(List<UserRoleDTO> userRoleDTOList) {

  }

  @Override
  public void revokeRoles(List<UserRoleDTO> userRoleDTOList) {

  }

  @Override
  public void assignDefaultRole(User user) {
    Role defaultRole = roleRepository.findRoleByName(DEFAULT_ROLE_NAME);
    if (user.getRoles() == null)
      user.setRoles(List.of(defaultRole));
    else
      user.getRoles().add(defaultRole);
  }
}
