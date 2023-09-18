package com.example.book_blog.service;

import org.springframework.stereotype.Service;

import com.example.book_blog.model.Post;
import com.example.book_blog.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;
	
	public Post insert(Post post) {
		return postRepository.save(post);
	}

}
