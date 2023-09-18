package com.example.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.book.dto.Comment;

public interface CommentRepository 
				extends JpaRepository<Comment, Long>{
	@Query("select sc from Comment sc where pid =?1")
	public List<Comment> findByPid (Long pid);

}
