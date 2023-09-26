package com.example.book_blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_blog.dto.CommentDTO;
import com.example.book_blog.dto.PostDTO;
import com.example.book_blog.entity.Post;
import com.example.book_blog.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;
	
	@PutMapping("/postInsert")
	public PostDTO insert(@RequestBody PostDTO postDTO) {
		Post post = postDTO.CreatePost();
		post = postService.save(post);
		return PostDTO.builder().id(post.getId())
								.title(post.getTitle())
								.content(post.getContent())
								.build();
	}
	@GetMapping("/postList")
	public List<PostDTO> findAll() {
		List<Post> posts = postService.findAll();
		List<PostDTO> postlist = new ArrayList<>();
		for(Post post : posts) {
			postlist.add(
				PostDTO.builder().id(post.getId())
								.title(post.getTitle())
								.content(post.getContent())
								.build());
		}
		return postlist;
	}
	@GetMapping("/post/{num}")
	public PostDTO findById(@PathVariable long num) {
		Post post = postService.findById(num);
		return PostDTO.builder().id(post.getId())
								.title(post.getTitle())
								.content(post.getContent())
								.comments(post.getComments())
								.build();
	}
	@PutMapping("/insertCmt")
	public void insertCmt(@RequestBody CommentDTO commentDTO) {
		long postId =commentDTO.getPostid();
		commentDTO.setPost(postService.findById(postId));
		postService.insertCmt(postId, commentDTO.toEntity());
	}
	
}
