package com.example.todo_test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_test.entity.TodoEntity;
import com.example.todo_test.service.TodoService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/todo/*")
@RestController
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	
	@GetMapping("/todoList")
	public List<TodoEntity> todoList(){
		return todoService.findAllTodo();
	}
	
	@GetMapping("/view/{id}")
	public TodoEntity findByTodoId(@PathVariable long id) {
		return todoService.findByTodoId(id);
	}
	
	@PutMapping("/todoWrite")
	public void saveTodo(@RequestBody TodoEntity todoEntity) {
		todoService.saveTodo(todoEntity);	
	}
	
	@PutMapping("update/{id}")
	public void updateTodo(@PathVariable long id, @RequestBody TodoEntity todoEntity) {
		todoService.updateTodo(id, todoEntity);
	}
	@DeleteMapping("delete/{id}")
	public void deleteTodo(@PathVariable long id) {
		todoService.deleteTodo(id);
	}
}
