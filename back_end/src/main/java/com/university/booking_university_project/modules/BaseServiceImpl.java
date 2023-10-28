package com.university.booking_university_project.modules;

import com.university.booking_university_project.jpa.IdEntity;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<
        ENTITY extends IdEntity<ID>, ID extends Serializable, DAO extends JpaRepository<ENTITY, ID>>
    implements BaseService<ENTITY, ID, DAO> {

  private final DAO dao;

  @Autowired
  protected BaseServiceImpl(DAO dao) {
    this.dao = dao;
  }

  @Override
  public ENTITY save(ENTITY entity) {
    return this.dao.save(entity);
  }

  @Override
  public Optional<ENTITY> findById(ID id) {
    return this.dao.findById(id);
  }

  @Override
  public void delete(ENTITY entity) {
    this.dao.delete(entity);
  }

  @Override
  public void deleteById(ID id) {
    this.dao.deleteById(id);
  }
}
