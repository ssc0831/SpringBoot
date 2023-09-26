package com.example.exam_todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exam_todo.model.Todo;
import com.example.exam_todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoRepository todoRepository;
	
	// 추가
	public Todo insert(Todo todo) {
		return todoRepository.save(todo);
	}
	
	// 전체보기
	public List<Todo> list(){
		return todoRepository.findAll();
	}
	
	// 수정
	public Todo Modify(Todo todo) {
		return todoRepository.save(todo);
	}
	
	
	// 삭제
	public void delete(Long num) {
		todoRepository.deleteById(num);
	}

}
