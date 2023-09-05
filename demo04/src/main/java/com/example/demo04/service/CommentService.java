package com.example.demo04.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo04.model.Board;
import com.example.demo04.model.Comment;
import com.example.demo04.repository.BoardRepository;
import com.example.demo04.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	
	// 댓글 list 전체 보기
	public List<Comment> list(Long bnum) {
		return commentRepository.findByBnum(bnum);
	}
	
	
	@Transactional
	public void insert(Comment comment) {
		// 댓글 추가
		//commentRepository.save(comment);
		//replycnt +1(Update)
		Board b = boardRepository.findById(comment.getBoard().getNum()).get();
		b.setReplycnt(b.getReplycnt()+1);//update
		
		// SQL
		commentRepository.insert(comment.getContent(), comment.getBoard()
		.getNum(),comment.getUser().getId());
	}

	// 댓글 삭제
	@Transactional
	public void delete(Long cnum) {
	Optional<Comment> c = commentRepository.findById(cnum);
	// board에 있는 replycnt 값을 -1(1감소)로 수정
		Board b = c.get().getBoard();
		b.setReplycnt(b.getReplycnt()-1);
		commentRepository.deleteById(cnum);
	}
	
}