package com.github.aranfern.application;

import com.github.aranfern.domain.User;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public User getById(@PathVariable(name = "id") UUID id) {
    return userService.getById(id);
  }

  @PostMapping
  public void signUp(@RequestBody User user) {
    userService.signUp(user);
  }
}
