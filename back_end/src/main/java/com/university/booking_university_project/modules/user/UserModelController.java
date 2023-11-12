package com.university.booking_university_project.modules.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/Model/User")
public class UserModelController {

  private final UserService userService;

  public UserModelController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/searchAll")
  public String searchUsers(Model model) {
    model.addAttribute("userDTOList", userService.findAllDTO());
    return "userController/searchUsers";
  }

  @PostMapping("/editUsers")
  public String editUsers(Model model) {
    model.addAttribute("userDTO", userService.findAllDTO().stream().findAny().get());
    return "userController/editUsers";
  }
}
