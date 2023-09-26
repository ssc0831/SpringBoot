package com.example.book_blog.dto;

import java.util.List;

import com.example.book_blog.entity.Comment;
import com.example.book_blog.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	private long id;
	private String title;
	private String content;
	private List<Comment> comments;
	
	public Post CreatePost() {
		return Post.builder().title(title)
								.content(content)
								.build();
	}
}
