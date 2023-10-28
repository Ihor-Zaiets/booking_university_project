package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> saveAll(List<User> users) {
    return userRepository.saveAll(users);
  }

  @Override
  public void deleteAll(List<User> users) {
    userRepository.deleteAll(users);
  }

  @Override
  public void deleteAllByIds(List<Integer> ids) {
    userRepository.deleteAllById(ids);
  }

  @Override
  public Optional<User> findById(Integer id) {
    return userRepository.findById(id);
  }
}
