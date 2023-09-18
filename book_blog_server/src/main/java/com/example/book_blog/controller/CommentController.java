package com.example.book_blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_blog.model.Post;
import com.example.book_blog.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;
	
	// 추가
	@PostMapping("/post-write/insert")
	public Post insert(@RequestBody Post post) {
		return commentService.insert(post);
	}
	

}
