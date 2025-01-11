package com.github.aranfern.application;

import com.github.aranfern.domain.LoginRequest;
import com.github.aranfern.domain.LoginResponse;
import com.github.aranfern.infrastructure.AuthenticationRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private final AuthenticationRepository authenticationRepository;

  public AuthenticationService(AuthenticationRepository authenticationRepository) {
    this.authenticationRepository = authenticationRepository;
  }

  public LoginResponse login(LoginRequest loginRequest) {
    return authenticationRepository.login(loginRequest);
  }
}
