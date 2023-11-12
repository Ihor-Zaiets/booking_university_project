package com.university.booking_university_project.modules.role;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.jpa.entity.Role;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImplBaseTest implements BaseServiceTest<Role, Integer, RoleServiceImpl> {

  private final RoleRepository roleRepository;

  private final Mapper mapper;

  public static final String TEST_ROLE_NAME = "ADMIN";

  @Autowired
  public RoleServiceImplBaseTest(RoleRepository roleRepository, Mapper mapper) {
    this.roleRepository = roleRepository;
    this.mapper = mapper;
  }

  @Override
  public RoleServiceImpl createService() {
    return new RoleServiceImpl(roleRepository, mapper);
  }

  @Override
  public Role createEntity() {
    Role role = new Role();
    role.setName(TEST_ROLE_NAME);
    return role;
  }
}
