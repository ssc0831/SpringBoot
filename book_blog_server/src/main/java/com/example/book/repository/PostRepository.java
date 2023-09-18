package com.example.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.dto.Post;

public interface PostRepository 
				extends JpaRepository<Post, Long>{

}
