package com.example.demo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo04.model.FileBoard;
import com.example.demo04.service.FileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/file2/*")
@RequiredArgsConstructor
public class FileController2 {
	private final FileService fileService;
	
	@GetMapping("insert")
	public String insert() {
		return "/file2/fileboardInsert";
	}
	
	@PostMapping("Insert")
	public String insert(FileBoard board) {
		fileService.fileInsert(board);
		return "redirect:list";
	}
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("lists", fileService.list());
		return "/file2/list";
	}
}
