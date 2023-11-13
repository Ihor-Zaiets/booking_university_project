package com.university.booking_university_project.modules.role;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.entity.Role;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.role.dto.RoleCreationDTO;
import com.university.booking_university_project.modules.role.dto.RoleDTO;
import com.university.booking_university_project.modules.role.dto.RoleUpdateDTO;
import com.university.booking_university_project.modules.role.dto.UserRoleDTO;
import com.university.booking_university_project.modules.role.repository.RoleRepository;
import com.university.booking_university_project.validators.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  private final Mapper mapper;

  public static final String DEFAULT_ROLE_NAME = "USER";

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository, Mapper mapper) {
    this.roleRepository = roleRepository;
    this.mapper = mapper;
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
  public List<RoleDTO> createRoles(List<RoleCreationDTO> roleCreationDTOList) {
    List<Role> roles = new ArrayList<>();
    for (RoleCreationDTO roleCreationDTO : roleCreationDTOList) {
      validateRole(roleCreationDTO);
      roles.add(mapper.map(roleCreationDTO, Role.class));
    }
    roles = roleRepository.saveAll(roles);
    return roles.stream().map(role -> mapper.map(role, RoleDTO.class)).collect(Collectors.toList());
  }

  private <DTO extends RoleUpdateDTO> void validateRole(DTO roleCreationDTO) {
    Validation.validateObjectNullOrEmpty(roleCreationDTO.getName());
    validateRoleUniqueness(roleCreationDTO.getName());
  }

  private void validateRoleUniqueness(String name) {
    if (roleRepository.existsByName(name))
      throw new ValidationException(ExceptionMessage.ROLE_ALREADY_EXISTS_VALIDATION_MESSAGE);
  }

  @Override
  public List<RoleDTO> findAllRolesDTO() {
    return roleRepository.findAll().stream().map(entity -> mapper.map(entity, RoleDTO.class)).collect(Collectors.toList());
  }

  @Override
  public List<RoleDTO> editRoles(List<RoleUpdateDTO> roleUpdateDTOList) {
    List<Role> roles = new ArrayList<>();
    for (RoleUpdateDTO roleUpdateDTO : roleUpdateDTOList) {
      roles.add(mapper.map(roleUpdateDTO, Role.class));
    }
    roles = roleRepository.saveAll(roles);
    return roles.stream().map(role -> mapper.map(role, RoleDTO.class)).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public void grantRoles(List<UserRoleDTO> userRoleDTOList) {
    for (UserRoleDTO userRoleDTO : userRoleDTOList) {
      roleRepository.assignRoleToUser(userRoleDTO.getUserId(), userRoleDTO.getRoleId());
    }
  }

  @Transactional
  @Override
  public void revokeRoles(List<UserRoleDTO> userRoleDTOList) {
    for (UserRoleDTO userRoleDTO : userRoleDTOList) {
      roleRepository.unassignRoleFromUser(userRoleDTO.getUserId(), userRoleDTO.getRoleId());
    }
  }

  /**
   * Adds {@link #DEFAULT_ROLE_NAME} to user roles. If user roles is null, then return new List with default role.
   * */
  @Override
  public void assignDefaultRole(User user) {
    Role defaultRole = roleRepository.findRoleByName(DEFAULT_ROLE_NAME);
    if (user.getRoles() == null)
      user.setRoles(List.of(defaultRole));
    else
      user.getRoles().add(defaultRole);
  }
}
