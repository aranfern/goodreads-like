package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.LoginRequest;
import com.github.aranfern.domain.LoginResponse;

public interface AuthenticationRepository {
  LoginResponse login(LoginRequest loginRequest);
}
