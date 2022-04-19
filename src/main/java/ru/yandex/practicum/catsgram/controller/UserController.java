package ru.yandex.practicum.catsgram.controller;


import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

@Slf4j
@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/users")
  public List<User> findAll() {
    return userService.findAll();
  }

  @PostMapping(value = "/users")
  public User postUser(@RequestBody User user)
      throws InvalidEmailException, UserAlreadyExistException {
    return userService.createUser(user);
  }

  @PutMapping("/users")
  public User putUser(@RequestBody User user) throws InvalidEmailException {
    return userService.updateUser(user);
  }
}
