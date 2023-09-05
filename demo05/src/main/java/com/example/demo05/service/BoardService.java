package com.example.demo05.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo05.dto.BoardDTO;
import com.example.demo05.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper boardMapper;
	
	public void insert(BoardDTO board) {
	boardMapper.insert(board);
	}

	// 전체보기(페이징)
	public List<BoardDTO> pagelist(int pageStart, int pageSize) {
		return boardMapper.pagelist(pageStart, pageSize);
	}
	
	// 전체보기
	public List<BoardDTO> list() {
		return boardMapper.list();
	}

	public BoardDTO view(int num) {
		return boardMapper.view(num);
	}

	public int getCount() {
		return boardMapper.count();
	}

}

