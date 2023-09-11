package com.example.ezorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezorder.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
	
}
