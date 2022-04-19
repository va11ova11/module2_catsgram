package ru.yandex.practicum.catsgram.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;

@Service
public class PostService {

  private final UserService userService;
  private final List<Post> posts;

  @Autowired
  public PostService(UserService userService) {
    this.userService = userService;
    posts = new ArrayList<>();
  }

  public List<Post> findAll() {
    return posts;
  }

  public Post create(Post post) {
    if(userService.findByEmail(post.getAuthor()).isEmpty()) {
        throw new UserNotFoundException(String.format(
            "Пользователь %s не найден", post.getAuthor()));
    }
    posts.add(post);
    return post;
  }
}

