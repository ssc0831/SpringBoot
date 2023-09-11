package com.example.app09_todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app09_todo.model.Todo;

@Repository
public interface TodoRepository  
           extends JpaRepository<Todo, Long>{

}
