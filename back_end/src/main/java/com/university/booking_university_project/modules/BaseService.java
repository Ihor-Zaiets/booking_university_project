package com.university.booking_university_project.modules;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {

  List<T> saveAll(List<T> ts);

  void deleteAll(List<T> ts);

  void deleteAllByIds(List<ID> ids);

  default T save(T t) {
    return saveAll(List.of(t)).get(0);
  }

  Optional<T> findById(ID id);

  default void delete(T t) {
    deleteAll(List.of(t));
  }

  default void deleteById(ID id) {
    deleteAllByIds(List.of(id));
  }
}
