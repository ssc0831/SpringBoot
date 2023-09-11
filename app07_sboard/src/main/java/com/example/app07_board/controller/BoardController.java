package com.example.app07_board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app07_board.model.Board;
import com.example.app07_board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
    @GetMapping("/home")
    public String home() {
    	System.out.println("home");
        return "success";
    }
    
    // 추가
    @PostMapping("/api/insert")
    public void insert(@RequestBody Board board) {
    	System.out.println(board.getTitle());
    	System.out.println(board.getContent());
    	boardService.insert(board);
    }
    
    // 전체보기
    @GetMapping("/api/list")
    public List<Board> list(){
    	return boardService.findAll();
    }
    
    // 삭제
    @DeleteMapping("/api/delete/{num}")
    public void name(@PathVariable long num) {
		boardService.delete(num);
	}
}
