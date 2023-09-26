package com.example.todo_test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo_test.entity.TodoEntity;
import com.example.todo_test.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoRepository todoRepository;
	
	public List<TodoEntity> findAllTodo(){
		return todoRepository.findAll();
	}
	
	public void saveTodo(TodoEntity todoEntity) {
		todoRepository.save(todoEntity);
	}
	
	public TodoEntity findByTodoId(long id) {
		return todoRepository.findById(id).get();
	}
	@Transactional
	public void updateTodo(long id, TodoEntity todoEntity) {
		TodoEntity todo = todoRepository.findById(id).get();
		todo.updateEntity(todoEntity.getTitle(), todoEntity.getContent());
	}
	public void deleteTodo(long id) {
		todoRepository.deleteById(id);
	}
}
