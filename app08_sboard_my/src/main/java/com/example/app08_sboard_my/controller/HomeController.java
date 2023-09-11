package com.example.app08_sboard_my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app08_sboard_my.dto.Board;
import com.example.app08_sboard_my.service.BoardService;

@RestController
public class HomeController {
	@Autowired
	private BoardService boardService;
	
	//전체보기
	@GetMapping("api/list")
	public List<Board> list(){
		return boardService.list();
	}
	
	// 추가
	@PostMapping("/api/insert")
	public Long insert(@RequestBody Board board) {
		boardService.insert(board);
		System.out.println(board.getNum());
		return board.getNum();
		
	}
	
//		// 추가 - 앞선 7번의 것을 사용하여 적용시에는 이걸로 써야함.
//		@PostMapping("/api/insert")
//		public Board insert(@RequestBody Board board) {
//			boardService.insert(board);
//			System.out.println(board);
//			return board;
//			
//		}
	

}
