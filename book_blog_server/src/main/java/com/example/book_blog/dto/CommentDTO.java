package com.example.book_blog.dto;

import com.example.book_blog.entity.Comment;
import com.example.book_blog.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class CommentDTO {
	private long id;
	private String content;
	private long postid;
	private Post post;
	
	public Comment toEntity() {
		return Comment.builder().id(id)
								.content(content)
								.post(post)
								.build();
	}
}
