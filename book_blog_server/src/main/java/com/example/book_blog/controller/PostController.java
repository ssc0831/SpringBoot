package com.example.book_blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_blog.model.Post;
import com.example.book_blog.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/post/")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	// 추가
	@PostMapping("insert")
	public Post insert(@RequestBody Post post) {
		System.out.println("insert");
		return postService.insert(post);
	}
}
