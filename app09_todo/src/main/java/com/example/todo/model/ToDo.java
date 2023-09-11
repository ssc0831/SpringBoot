package com.example.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class ToDo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String subject;
	private String name;
	private String summary;
}
