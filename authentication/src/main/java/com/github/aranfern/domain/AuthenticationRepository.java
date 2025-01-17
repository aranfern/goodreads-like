package com.github.aranfern.domain;

public interface AuthenticationRepository {
  LoginResponse login(LoginRequest loginRequest);
}
