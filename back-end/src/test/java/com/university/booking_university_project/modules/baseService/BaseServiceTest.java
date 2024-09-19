package com.university.booking_university_project.modules.baseService;

import com.university.booking_university_project.jpa.IEntity;
import com.university.booking_university_project.modules.BaseService;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
@SpringBootTest
public interface BaseServiceTest<ENTITY extends IEntity<ID>, ID extends Serializable, SERVICE extends BaseService<ENTITY, ID>> {

    SERVICE createService();

    ENTITY createEntity();

    @Test
    @Order(1)
    default void saveAll() {
        SERVICE service = createService();
        ENTITY entity1 = createEntity();
        ENTITY entity2 = createEntity();

        Assertions.assertNull(entity1.getId());
        Assertions.assertNull(entity2.getId());
        List<ENTITY> entities = service.saveAll(List.of(entity1, entity2));
        Assertions.assertFalse(entities.isEmpty());
        Assertions.assertNotNull(entity1.getId());
        Assertions.assertNotNull(entity2.getId());
    }

    @Test
    @Order(2)
    default void findById() {
        SERVICE service = createService();
        ENTITY entity = createEntity();
        entity = service.save(entity);

        Optional<ENTITY> optional = service.findById(entity.getId());
        Assertions.assertTrue(optional.isPresent());
    }

    @Test
    @Order(3)
    default void deleteAll() {
        SERVICE service = createService();
        ENTITY entity1 = createEntity();
        ENTITY entity2 = createEntity();
        List<ENTITY> entities = service.saveAll(List.of(entity1, entity2));
        ID entity1Id = entity1.getId();
        ID entity2Id = entity2.getId();

        service.deleteAll(entities);
        Assertions.assertFalse(service.findById(entity1Id).isPresent());
        Assertions.assertFalse(service.findById(entity2Id).isPresent());
    }

    @Test
    @Order(4)
    default void deleteAllByIds() {
        SERVICE service = createService();
        ENTITY entity1 = createEntity();
        ENTITY entity2 = createEntity();
        List<ENTITY> entities = service.saveAll(List.of(entity1, entity2));
        ID entity1Id = entity1.getId();
        ID entity2Id = entity2.getId();

        service.deleteAllByIds(entities.stream().map(ENTITY::getId).collect(Collectors.toList()));
        Assertions.assertFalse(service.findById(entity1Id).isPresent());
        Assertions.assertFalse(service.findById(entity2Id).isPresent());
    }
}
