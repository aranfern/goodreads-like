package com.github.aranfern.infrastructure;

import com.github.aranfern.domain.User;
import com.github.aranfern.domain.UserNotFound;
import com.github.aranfern.domain.UserRepository;
import java.util.HashMap;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class UserInMemoryRepository implements UserRepository {
  private final HashMap<UUID, User> users = new HashMap<>();

  @Override
  public User getById(UUID id) {
    if (!users.containsKey(id)) {
      throw new UserNotFound();
    }

    return users.get(id);
  }

  @Override
  public void create(User user) {
    users.put(user.getId(), user);
  }
}
