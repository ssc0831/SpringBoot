package com.example.app08_sboard_my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app08_sboard_my.dto.Board;
import com.example.app08_sboard_my.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	public List<Board> list(){
		return boardMapper.list();
	}
	//추가
	public void insert(Board board) {
		boardMapper.insert(board);
	}

}
