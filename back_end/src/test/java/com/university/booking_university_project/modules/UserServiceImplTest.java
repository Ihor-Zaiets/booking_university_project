package com.university.booking_university_project.modules;

import com.university.booking_university_project.modules.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserServiceImplTest(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
}
