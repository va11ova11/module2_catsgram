package ru.yandex.practicum.catsgram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

@Service
public class UserService {

  private final List<User> users = new ArrayList<>();

  public Optional<User> findByEmail(String author) {
    return users.stream()
        .filter(u -> u.getEmail().equals(author))
        .findAny();
  }

  public List<User> findAll() {
    return users;
  }

  public User createUser(User user) throws InvalidEmailException, UserAlreadyExistException {
    if (user.getEmail() == null | user.getEmail().isEmpty()) {
      throw new InvalidEmailException("Введён некорректный email");
    } else if (users.contains(user)) {
      throw new UserAlreadyExistException("Пользователь с таким email уже существует");
    } else {
      users.add(user);
      return user;
    }
  }

  public User updateUser(User user) throws InvalidEmailException {
    if (user.getEmail() == null || user.getEmail().isEmpty()) {
      throw new InvalidEmailException("Введён некорректный email");
    } else {
      users.removeIf(user1 -> user1.getEmail().equals(user.getEmail()));
      users.add(user);
      return user;
    }
  }
}
