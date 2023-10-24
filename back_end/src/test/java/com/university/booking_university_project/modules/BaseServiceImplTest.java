package com.university.booking_university_project.modules;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.user.UserServiceImpl;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * <p>All tests have been written with assumption, that on beginning of each test database has no data, except migrations.
 *
 * <p>For organisational and aesthetic purposes add annotation @{@link Order} for each new test.
 *
 * @author Ihor Zaiets
 * */
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BaseServiceImplTest {

    private final UserServiceImpl userServiceImpl;
    
    private final UserRepository userRepository;

    @Autowired
    public BaseServiceImplTest(UserServiceImpl userServiceImpl, UserRepository userRepository) {
        this.userServiceImpl = userServiceImpl;
        this.userRepository = userRepository;
    }

    @Test
    @Order(1)
    public void save(){
        User user = new User();
        user.setName("name");
        user.setSurname("name");
        user.setAddress("name");
        user.setEmail("name");
        user.setPhone("name");
        user = userServiceImpl.save(user);
        Optional<User> userOptional = userRepository.findById(user.getId());
        Assertions.assertTrue(userOptional.isPresent());
    }

    @Test
    @Order(2)
    public void update() {
        User user = new User();
        user.setName("name");
        user.setSurname("name");
        user.setAddress("name");
        user.setEmail("name");
        user.setPhone("name");
        user = userServiceImpl.save(user);
        Optional<User> userOptional = userRepository.findById(user.getId());
        Assertions.assertTrue(userOptional.isPresent());
    }
}
