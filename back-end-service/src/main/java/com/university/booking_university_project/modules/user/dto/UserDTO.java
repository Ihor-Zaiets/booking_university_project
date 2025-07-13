package com.university.booking_university_project.modules.user.dto;

import com.university.booking_university_project.modules.role.dto.RoleDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Integer id;

    private String login;

    private String password;

    private List<RoleDTO> roles;

    private String firstname;

    private String surname;

    private String email;

    private String phone;

    private String address;
}
