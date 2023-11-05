package com.university.booking_university_project.modules.role;

import com.university.booking_university_project.jpa.entity.Role;
import com.university.booking_university_project.modules.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

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
}
