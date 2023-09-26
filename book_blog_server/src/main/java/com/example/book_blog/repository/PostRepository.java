package com.example.book_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book_blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
