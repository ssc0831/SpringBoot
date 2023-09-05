package com.example.demo04.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo04.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	// 댓글 추가
	@Modifying
	@Query(value = "insert into tbl_comment4(content, regdate, bnum, user_id)"
			+ "values(?1, now(), ?2, ?3)", nativeQuery = true)
	public void insert(String content, Long bnum, Long user_id);
	
	// 댓글 리스트
	//JPQL(Java Persistant Query Language) : Entity Object를 중심
	@Query("select sc from tbl_comment4 sc join fetch sc.board where bnum=?1") // 	LAZY(fetch join을 사용)
	//@Query("select sc from tbl_comment4 sc where bnum=?1")
	public List<Comment> findByBnum(Long bnum);
}
