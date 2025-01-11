package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.User;
import java.util.UUID;

public interface UserRepository {
  User getById(UUID id);

  void create(User user);
}
