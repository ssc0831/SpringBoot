package com.example.book_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.book_blog.model.Comment;
import com.example.book_blog.model.Post;

@Repository
public interface CommentRepository extends
	JpaRepository<Comment, Long> {

	// 댓글 추가
	@Modifying
	@Query(value = "insert into comment (content, pid) ", nativeQuery = true)
		public void insert(String content, Long pid);


}
