package com.university.booking_university_project.modules.user;

import com.github.dozermapper.core.Mapper;
import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ResourceNotFoundException;
import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.role.RoleService;
import com.university.booking_university_project.modules.user.dto.UserCreateDTO;
import com.university.booking_university_project.modules.user.dto.UserRegistrationRequest;
import com.university.booking_university_project.modules.user.dto.UserUpdateDTO;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import com.university.booking_university_project.validators.Validation;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final RoleService roleService;

  private final Mapper mapper;

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, RoleService roleService, Mapper mapper, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleService = roleService;
    this.mapper = mapper;
    this.passwordEncoder = passwordEncoder;
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
  public List<UserDTO> createUsers(List<UserCreateDTO> userCreationDTOList) {
    List<User> users = new ArrayList<>();
    for (UserCreateDTO userCreationDTO : userCreationDTOList) {
      validateUserCreation(userCreationDTO);
      users.add(mapper.map(userCreationDTO, User.class));
    }
    List<User> savedUsers = userRepository.saveAll(users);
    return savedUsers.stream().map(user -> mapper.map(user, UserDTO.class)).toList();
  }

  @Override
  public List<UserDTO> findAllDTO() {
    return userRepository.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).sorted(Comparator.comparingInt(UserDTO::getId)).collect(Collectors.toList());
  }

  @Override
  public List<UserDTO> editUsers(List<UserUpdateDTO> userUpdateDTOList) {
    List<User> users = new ArrayList<>();
    for (UserUpdateDTO userUpdateDTO : userUpdateDTOList) {
      User user = getById(userUpdateDTO.getId());
      validateUserUpdate(user, userUpdateDTO);
      mapper.map(userUpdateDTO, user);
      users.add(user);
    }
    List<User> savedUsers = userRepository.saveAll(users);
    return savedUsers.stream().map(user -> mapper.map(user, UserDTO.class)).sorted(Comparator.comparingInt(UserDTO::getId)).toList();
  }

  @Override
  public UserDTO signUp(UserRegistrationRequest registrationRequest) {
    User user = mapper.map(registrationRequest, User.class);
    roleService.assignDefaultRole(user);
    if (user.getPassword() != null)
      user.setPassword(passwordEncoder.encode(user.getPassword()));

    user = userRepository.save(user);
    return mapper.map(user, UserDTO.class);
  }

  @Override
  public User findByLogin(String login) {
    return userRepository.findByLogin(login);
  }

  @Override
  public UserDTO toDTO(User user) {
    if (user == null)
      return null;
    return mapper.map(user, UserDTO.class);
  }

  private void validateUserCreation(UserCreateDTO userUpdateDTO) {
    Validation.validateUserFirstName(userUpdateDTO.getFirstname());
    Validation.validateUserSurname(userUpdateDTO.getSurname());
    Validation.validateEmail(userUpdateDTO.getEmail());
    validateEmailAlreadyExist(userUpdateDTO.getEmail());
    Validation.validatePhoneWithMessagePrefix(userUpdateDTO.getPhone(), Validation.PHONE_FIELD_EXCEPTION_MESSAGE_PREFIX + " ");
  }

  private void validateUserUpdate(User user, UserUpdateDTO userUpdateDTO) {
    if (!Objects.equals(userUpdateDTO.getFirstname(), user.getFirstname())) {
      Validation.validateUserFirstName(userUpdateDTO.getFirstname());
    }
    if (!Objects.equals(userUpdateDTO.getSurname(), user.getSurname())) {
      Validation.validateUserSurname(userUpdateDTO.getSurname());
    }
    if (!Objects.equals(userUpdateDTO.getEmail(), user.getEmail())) {
      Validation.validateEmail(userUpdateDTO.getEmail());
      validateEmailAlreadyExist(userUpdateDTO.getEmail());
    }
    if (!Objects.equals(userUpdateDTO.getPhone(), user.getPhone())) {
      Validation.validatePhoneWithMessagePrefix(userUpdateDTO.getPhone(), Validation.PHONE_FIELD_EXCEPTION_MESSAGE_PREFIX + " ");
    }
  }

  public void validateEmailAlreadyExist(String email) {
    if (email != null && userRepository.existsByEmail(email))
      throw new ValidationException(ExceptionMessage.EMAIL_ALREADY_EXISTS_VALIDATION_MESSAGE);
  }

  public User getById(Integer userId) {
    return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(ExceptionMessage.USER_NOT_FOUND_EXCEPTION));
  }
}
