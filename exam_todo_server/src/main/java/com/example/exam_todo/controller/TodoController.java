package com.example.exam_todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam_todo.model.Todo;
import com.example.exam_todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	//추가
	@PostMapping("/todo/insert")
	public Todo insert(@RequestBody Todo todo) {
		return todoService.insert(todo);
	}
	
	//전체보기
	@GetMapping("/todo/list")
	public List<Todo> list(){
		return todoService.list();
	}
	
	// 수정
	@PutMapping("/todo/modify/{num}")
	public Todo modify(@RequestBody Todo todo) {
	    return todoService.Modify(todo);
	}

	
	//삭제
	@DeleteMapping("/todo/delete/{num}")
	public void delete(@PathVariable Long num) {
		todoService.delete(num);
	}

}
