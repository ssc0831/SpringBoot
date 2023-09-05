package com.example.demo04.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo04.model.User;
import com.example.demo04.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRespository;
	private final BCryptPasswordEncoder encoder;

	public void join(User user) {
		// 비밀번호 암호화
		String encPassword = encoder.encode(user.getPassword()); // 암호화된 비번
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		userRespository.save(user);
	}
}
