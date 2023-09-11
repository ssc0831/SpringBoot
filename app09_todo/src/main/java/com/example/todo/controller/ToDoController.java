package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ToDoController {
	private final ToDoService todoService;
	@GetMapping("/home")
	public String home() {
		System.out.println("home");
		return "success";
	}
	
	// 추가
	@PostMapping("/todo/insert")
	public void insert(@RequestBody ToDo toDo) {
		System.out.println(toDo.getName());
		System.out.println(toDo.getSubject());
		System.out.println(toDo.getSummary());
		todoService.insert(toDo);
	}
	
	// 전체보기
	@GetMapping("/todo/list")
	public List<ToDo> list() {
		return todoService.list();
	}
	
	// 삭제
	@DeleteMapping("/todo/delete/{num}")
	public void delete(@PathVariable num) {
		todoService.delete(num);
	}
}
