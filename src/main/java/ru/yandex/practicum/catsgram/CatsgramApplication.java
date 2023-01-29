package ru.yandex.practicum.catsgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.yandex.practicum.catsgram.model.Post;

@SpringBootApplication
public class CatsgramApplication {

	public static void main(String[] args) {

		SpringApplication.run(CatsgramApplication.class, args);
		Post post = Post.builder()
				.author("author")
				.description("desc")
				.photoUrl("url")
				.build();



		Post post2 = post.toBuilder().author("author2").build();
		System.out.println(post.hashCode());
		System.out.println(post2.hashCode());


	}

}
