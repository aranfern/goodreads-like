package com.github.aranfern.domain;

import java.util.UUID;

public interface UserRepository {
  User getById(UUID id);

  void create(User user);
}
