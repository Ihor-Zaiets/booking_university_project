package com.university.booking_university_project.modules.baseService;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * All tests have been written with assumption, that on beginning of each test database has no data,
 * except migrations.
 *
 * <p>For organisational and aesthetic purposes add annotation {@link Order} for each new test.
 *
 * @author Ihor Zaiets
 */
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class Test {

  @org.junit.jupiter.api.Test
  @Order(1)
  public void save() {}
}
