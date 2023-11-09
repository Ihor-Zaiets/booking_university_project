package com.university.booking_university_project.modules.user;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.user.dto.UserCreationDTO;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import com.university.booking_university_project.validators.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final Mapper mapper;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, Mapper mapper) {
    this.userRepository = userRepository;
    this.mapper = mapper;
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

  @Override
  public List<UserDTO> createUsers(List<UserCreationDTO> userCreationDTOList) {
    List<User> users = new ArrayList<>();
    for (UserCreationDTO userCreationDTO : userCreationDTOList) {
      validateUser(userCreationDTO);
      users.add(mapper.map(userCreationDTO, User.class));
    }
    List<User> savedUsers = userRepository.saveAll(users);
    return savedUsers.stream().map(user -> mapper.map(user, UserDTO.class)).toList();
  }

  @Override
  public List<UserDTO> findAllDTO() {
    return userRepository.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
  }

  @Override
  public List<UserDTO> editUsers(List<UserCreationDTO> userCreationDTOList) {
    List<User> users = new ArrayList<>();
    for (UserCreationDTO userCreationDTO : userCreationDTOList) {
      validateUser(userCreationDTO);
      users.add(mapper.map(userCreationDTO, User.class));
    }
    List<User> savedUsers = userRepository.saveAll(users);
    return savedUsers.stream().map(user -> mapper.map(user, UserDTO.class)).toList();
  }

  private void validateUser(UserCreationDTO userCreationDTO) {
    Validation.validateUserFirstName(userCreationDTO.getFirstname());
    Validation.validateUserSurname(userCreationDTO.getSurname());
    Validation.validateEmail(userCreationDTO.getEmail());
    validateEmail(userCreationDTO.getEmail());
    Validation.validatePhone(userCreationDTO.getPhone());
  }

  private void validateEmail(String email) {
    if (userRepository.existsByEmail(email))
      throw new ValidationException(ExceptionMessage.EMAIL_ALREADY_EXISTS_VALIDATION_MESSAGE);
  }
}
