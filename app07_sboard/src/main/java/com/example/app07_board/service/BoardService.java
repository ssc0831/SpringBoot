package com.example.app07_board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app07_board.model.Board;
import com.example.app07_board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	
	// 추가
	public void insert(Board board) {
		boardRepository.save(board);
	}
	
	// 전체보기
	public List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	// 삭제
	public void delete(long num) {
		boardRepository.deleteById(num);
		
	}

}
