package com.university.booking_university_project.modules.auth;

import com.university.booking_university_project.modules.jwt.JwtService;
import com.university.booking_university_project.modules.jwt.dto.JwtAuthenticationResponse;
import com.university.booking_university_project.modules.security.SecurityService;
import com.university.booking_university_project.modules.user.UserService;
import com.university.booking_university_project.modules.user.UserServiceImpl;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.modules.user.dto.UserLoginRequest;
import com.university.booking_university_project.modules.user.dto.UserRegistrationRequest;
import com.university.booking_university_project.validators.Validation;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final SecurityService securityService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(
            UserServiceImpl userService,
            SecurityService securityService,
            JwtService jwtService,
            AuthenticationManager authenticationManager
    ) {
        this.userService = userService;
        this.securityService = securityService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDTO signUp(UserRegistrationRequest registrationRequest) {
        validateUser(registrationRequest);
        return userService.signUp(registrationRequest);
    }

    @Override
    public JwtAuthenticationResponse login(UserLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );
        var user = userService.findByLogin(request.getLogin());
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public UserDTO getLoggedUserDTO() {
        return userService.toDTO(securityService.getloggedUser());
    }

    private void validateUser(UserRegistrationRequest userRegistrationRequest) {
        Validation.validateUserFirstName(userRegistrationRequest.getFirstname());
        Validation.validateUserSurname(userRegistrationRequest.getSurname());
        Validation.validateEmail(userRegistrationRequest.getEmail());
        userService.validateEmailAlreadyExist(userRegistrationRequest.getEmail());
        Validation.validatePhone(userRegistrationRequest.getPhone());
        validateLogin(userRegistrationRequest.getLogin());
        validatePassword(userRegistrationRequest.getPassword());
    }

    private void validatePassword(String password) {
        Validation.validateObjectNullOrEmpty(password, Validation.PASSWORD_FIELD_EXCEPTION_MESSAGE_PREFIX);
        Validation.validateTrimSpaces(password, Validation.PASSWORD_FIELD_EXCEPTION_MESSAGE_PREFIX);
    }

    private void validateLogin(String login) {
        Validation.validateObjectNullOrEmpty(login, Validation.LOGIN_FIELD_EXCEPTION_MESSAGE_PREFIX);
        Validation.validateTrimSpaces(login, Validation.LOGIN_FIELD_EXCEPTION_MESSAGE_PREFIX);
    }
}
