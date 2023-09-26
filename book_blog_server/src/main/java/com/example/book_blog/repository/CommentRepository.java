package com.example.book_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book_blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
