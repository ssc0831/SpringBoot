package com.example.demo01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo01.dao.BoardMapper;
import com.example.demo01.dto.BoardDTO;
@Service
public class BoardServiceImpl  implements BoardService{
  @Autowired
  private BoardMapper bmapper;
	@Override
	public void insert(BoardDTO board) {
		bmapper.insert(board);
		
	}

	@Override
	public List<BoardDTO> list() {
		return bmapper.list();
	}

	@Override
	public BoardDTO findByNum(int num) {
		return bmapper.findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {
		bmapper.update(board);
		
	}

	@Override
	public void delete(int num) {
	  bmapper.delete(num);
		
	}

	@Override
	public int getCount() {
		return bmapper.getCount();
	}

}
