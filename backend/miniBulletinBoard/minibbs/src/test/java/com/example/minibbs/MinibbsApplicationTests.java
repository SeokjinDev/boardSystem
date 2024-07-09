package com.example.minibbs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.minibbs.entity.Post;
import com.example.minibbs.repository.PostRepository;

@SpringBootTest
class MinibbsApplicationTests {
	@Autowired
	private PostRepository postRepository;

	@Test
	void contextLoads() {
		// 데이터베이스 연동 테스트
		/*
		Post post1 = Post.builder()
						.title("테스트 제목 1")
						.content("테스트 콘첸츠 1")
						.author("테스트 작성자 1")
						.password("qwer")
						.build();
		postRepository.save(post1);
		*/
	}

}