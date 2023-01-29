package ru.yandex.practicum.catsgram.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.model.Post;

@Service
public class PostService {

  private final List<Post> posts = new ArrayList<>();

  public List<Post> findAll() {
    return posts;
  }

  public Post create(Post post) {
    posts.add(post);
    return post;
  }
}
