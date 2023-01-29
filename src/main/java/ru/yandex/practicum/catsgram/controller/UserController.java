package ru.yandex.practicum.catsgram.controller;


import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

@Slf4j
@RestController
public class UserController {

  private final List<User> users = new ArrayList<>();


  @GetMapping("/users")
  public List<User> findAll() {
    return users;
  }

  @PostMapping(value = "/users")
  public User postUser(@RequestBody User user)
      throws InvalidEmailException, UserAlreadyExistException {
    if (user.getEmail() == null | user.getEmail().isEmpty()) {
      throw new InvalidEmailException("Введён некорректный email");
    } else if (users.contains(user)) {
      throw new UserAlreadyExistException("Пользователь с таким email уже существует");
    } else {
      users.add(user);
      return user;
    }
  }

  @PutMapping("/users")
  public User putUser(@RequestBody User user) throws InvalidEmailException {
    if (user.getEmail() == null || user.getEmail().isEmpty()) {
      throw new InvalidEmailException("Введён некорректный email");
    } else {
      users.removeIf(user1 -> user1.getEmail().equals(user.getEmail()));
      users.add(user);
      return user;
    }
  }
}
