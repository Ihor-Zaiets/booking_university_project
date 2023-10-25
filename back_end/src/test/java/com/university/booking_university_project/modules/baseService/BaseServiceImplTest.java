package com.university.booking_university_project.modules.baseService;

import java.util.Optional;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>All tests have been written with assumption, that on beginning of each test database has no data, except migrations.
 *
 * <p>For organisational and aesthetic purposes add annotation {@link Order} for each new test.
 *
 * @author Ihor Zaiets
 * */
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BaseServiceImplTest {

    @InjectMocks
    private BaseServiceTestImpl baseServiceImpl;

    @Spy
    private BaseServiceTestRepository repositoryTest;

    @Test
    @Order(1)
    public void save(){
        Integer sum = baseServiceImpl.sum();
        BaseServiceTestEntity entity = baseServiceImpl.save(new BaseServiceTestEntity());

        Optional<BaseServiceTestEntity> optional = repositoryTest.findById(entity.getId());
        Assertions.assertDoesNotThrow(() -> optional.orElseThrow());
    }
}
