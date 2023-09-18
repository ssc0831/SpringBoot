package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.dto.Post;
import com.example.book.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;
	
	public void insert(Post post) {
		postRepository.save(post);
	}

	public List<Post> list() {
		return postRepository.findAll();
	}

	public Post detail(Long id) {
		return postRepository.findById(id).get();
	}
	


}
