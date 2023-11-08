package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.BaseService;
import com.university.booking_university_project.modules.user.dto.UserCreationDTO;
import com.university.booking_university_project.modules.user.dto.UserDTO;

import java.util.List;

public interface UserService extends BaseService<User, Integer> {
  List<UserDTO> createUsers(List<UserCreationDTO> userCreationDTOList);

  List<UserDTO> findAllDTO();

  List<UserDTO> editUsers(UserCreationDTO userCreationDTO);
}
