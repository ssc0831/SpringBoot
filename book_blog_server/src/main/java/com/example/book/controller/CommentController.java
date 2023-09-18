package com.example.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.dto.Comment;
import com.example.book.dto.Post;
import com.example.book.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class CommentController {
	
	private final CommentService commentService;
	
	@PostMapping("insert/{id}")
	private void insert(@RequestBody Comment comment, @PathVariable Long id) {
		Post post = new Post();
		post.setId(id);
		comment.setPost(post);
		commentService.insert(comment);
	}
	
	@GetMapping("list/{pid}")
	private List<Comment> list(@PathVariable Long pid) {
		List<Comment> lists = commentService.list(pid);
		System.out.println(lists.size());
		return lists;
	}
	
	
	

}
