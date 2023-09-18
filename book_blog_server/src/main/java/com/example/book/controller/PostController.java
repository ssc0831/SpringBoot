package com.example.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.dto.Post;
import com.example.book.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor 
@RequestMapping("/post/*")
public class PostController {
	private final PostService postService;
	
	@PostMapping("insert")
	private void insert(@RequestBody Post post) {
		postService.insert(post);
		
	}
	
	@GetMapping("list")
	private List<Post> list(){
		System.out.println("/post/list");
		return postService.list();
	}
	
	@GetMapping("detail/{id}")
	private Post detail(@PathVariable Long id) {
		Post post = postService.detail(id);
		return post;
	}
	
	

}
