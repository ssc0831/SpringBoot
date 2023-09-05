package com.example.demo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo04.model.Board;
import com.example.demo04.model.User;
import com.example.demo04.repository.UserRepository;
import com.example.demo04.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final UserService userService;
	private final UserRepository userRepository;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	// 로그인 폼
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
																																																														
	// 회원가입 폼
	@GetMapping("/join")
	public String join() {
		return "/user/join";
	}
	// 가입
	@PostMapping("/join")
	@ResponseBody
	public String join(@RequestBody User user) {
	// username이 있으면 fail 그렇지 않으면 success
		if (userRepository.findByUsername(user.getUsername())!=null) {
			return "fail";
		} 
		userService.join(user);
		return "success";
	}
	
//	// Board Insert
//		@GetMapping("/board/insert")
//		public String boardinsert() {
//			return "/board/insert";
//		}
//		
//		@PutMapping("/board/insert")
//		@ResponseBody
//		public String boardinsert(@RequestBody Board board) {
//			return "/board/insert";
//		}
//		
//		@GetMapping("/board/list")
//		public String list() {
//			return "/board/list";
//		}
//	
	
	
}
