package com.university.booking_university_project.modules.role;

import com.university.booking_university_project.jpa.entity.Role;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImplBaseTest implements BaseServiceTest<Role, Integer, RoleServiceImpl> {

  private final RoleRepository roleRepository;

  public static final String TEST_ROLE_NAME = "ADMIN";

  @Autowired
  public RoleServiceImplBaseTest(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public RoleServiceImpl createService() {
    return new RoleServiceImpl(roleRepository);
  }

  @Override
  public Role createEntity() {
    Role role = new Role();
    role.setName(TEST_ROLE_NAME);
    return role;
  }
}
