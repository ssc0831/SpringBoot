package com.example.todo_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.todo_test.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
	
}
