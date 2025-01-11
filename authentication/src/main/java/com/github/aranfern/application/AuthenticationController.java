package com.github.aranfern.application;

import com.github.aranfern.domain.LoginRequest;
import com.github.aranfern.domain.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    return authenticationService.login(loginRequest);
  }
}
