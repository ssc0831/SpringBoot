package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.dto.Comment;
import com.example.book.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	
	public void insert(Comment comment) {
		commentRepository.save(comment);
		
	}

	public List<Comment> list(Long pid) {
		
		return commentRepository.findByPid(pid);
	}

}
