package ru.yandex.practicum.catsgram.model;

import java.time.Instant;
import lombok.Builder;
import lombok.Value;


@Value
@Builder(toBuilder = true)
public class Post {

  String author; // автор
  @Builder.Default
  Instant creationDate = Instant.now(); // дата создания
  String description; // описание
  String photoUrl; // url-адрес фотографии

}