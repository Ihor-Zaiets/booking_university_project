package com.university.booking_university_project.modules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<
        ENTITY,
        ID extends Serializable,
        DAO extends JpaRepository<ENTITY, ID>> {

    ENTITY save(ENTITY entity);

    Optional<ENTITY> findById(ID id);

    void delete(ENTITY entity);

    void deleteById(ID id);
}
