package com.university.booking_university_project.modules;

import com.university.booking_university_project.jpa.IEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class EntityService<
        ENTITY extends IEntity<ID>,
        ID extends Serializable,
        DAO extends JpaRepository<ENTITY, ID>> {

  @Autowired
  protected DAO dao;

  protected List<ENTITY> saveAll(List<ENTITY> entities) {
    return dao.saveAll(entities);
  }

  protected void deleteAll(List<ENTITY> entities) {
    this.dao.deleteAll(entities);
  }

  protected void deleteAllByIds(List<ID> ids) {
    this.dao.deleteAllById(ids);
  }

  protected ENTITY save(ENTITY t) {
    return saveAll(List.of(t)).get(0);
  }

  protected void delete(ENTITY t) {
    deleteAll(List.of(t));
  }

  protected void deleteById(ID id) {
    deleteAllByIds(List.of(id));
  }

  public Optional<ENTITY> findById(ID id) {
    return dao.findById(id);
  }
}
