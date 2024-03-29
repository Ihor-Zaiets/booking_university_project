package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.BaseService;
import com.university.booking_university_project.modules.user.dto.*;
import java.util.List;

public interface UserService extends BaseService<User, Integer> {
    List<UserDTO> createUsers(List<UserCreateDTO> userCreationDTOList);

    List<UserDTO> findAllDTO();

    List<UserDTO> editUsers(List<UserUpdateDTO> userUpdateDTO);

    UserDTO signUp(UserRegistrationRequest registrationRequest);

    User findByLogin(String login);

    UserDTO toDTO(User user);

    void validateEmailAlreadyExist(String email);
    UserDataForReservationDTO getUserDataForReservation(Integer userId);
    UserDTO getUserDTOById(Integer userId);
}
