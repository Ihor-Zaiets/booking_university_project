package com.university.booking_university_project.modules;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.user.UserServiceImpl;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UserServiceImplTest {

    private final UserServiceImpl userServiceImpl;
    
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplTest(UserServiceImpl userServiceImpl, UserRepository userRepository) {
        this.userServiceImpl = userServiceImpl;
        this.userRepository = userRepository;
    }

    @Test
    public void save(){
        User user = new User();
        user = userServiceImpl.save(user);
        Optional<User> userOptional = userRepository.findById(user.getId());
        Assertions.assertTrue(userOptional.isPresent());
    }
}
