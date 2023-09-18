package com.example.book_blog.service;

import org.springframework.stereotype.Service;

import com.example.book_blog.model.Post;
import com.example.book_blog.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;

	public Post insert(Post post) {
		return commentRepository.insert(post);
	}

}
