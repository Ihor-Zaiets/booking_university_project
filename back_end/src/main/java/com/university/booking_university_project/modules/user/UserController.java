package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.modules.user.dto.UserCreateDTO;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.modules.user.dto.UserDataForReservationDTO;
import com.university.booking_university_project.modules.user.dto.UserUpdateDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/User")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createAll")
    public ResponseEntity<List<UserDTO>> createUsers(@RequestBody List<UserCreateDTO> userCreationDTOList) {
        return ResponseEntity.ok(userService.createUsers(userCreationDTOList));
    }

    @GetMapping("/searchAll")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllDTO());
    }

    @PatchMapping("/editAll")
    public ResponseEntity<List<UserDTO>> editUsers(@RequestBody List<UserUpdateDTO> userUpdateDTOList) {
        return ResponseEntity.ok(userService.editUsers(userUpdateDTOList));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteUsers(@RequestBody List<Integer> ids) {
        userService.deleteAllByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/userDataForReservation/{userId}")
    public ResponseEntity<UserDataForReservationDTO> getUserDataForReservation(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUserDataForReservation(userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUserDTOById(userId));
    }
}
