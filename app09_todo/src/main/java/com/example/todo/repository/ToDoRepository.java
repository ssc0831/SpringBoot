package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
