package com.example.oceandb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.oceandb.service.OceanDB_Service;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final OceanDB_Service oceanDB_Service;
	
	@GetMapping("/")
	public String home() {
		return " ";
	}
	
//	@PostMapping("/upload")
//	public String Upload(){
//		return " ";
//	}
	
	


	
}
