package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoService {
	private final ToDoRepository todoRepository;
	
	// 추가
	public void insert(ToDo toDo) {
		todoRepository.save(toDo);
	}
	
	// 전체보기
	public List<ToDo> list() {
		return todoRepository.findAll();
	}
	
	// 삭제
	public void delete(Long num) {
		return todoRepository.deleteById(num);
	}

	
}
