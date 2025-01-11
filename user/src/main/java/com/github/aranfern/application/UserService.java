package com.github.aranfern.application;

import com.github.aranfern.domain.User;
import com.github.aranfern.infrastructure.UserRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getById(UUID id) {
    return userRepository.getById(id);
  }

  public void signUp(User user) {
    userRepository.create(user);
  }
}
