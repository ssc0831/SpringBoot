package com.example.demo04.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo04.model.FileBoard;
import com.example.demo04.service.FileService;

@Controller
@RequestMapping("/file/*")
public class FileController {
	@Autowired
	private FileService fileService;
	
	@GetMapping("insert")
	public String insert() {
		return "/file/fileboardInsert";
	}
	
	@PostMapping("Insert")
	public String insert(FileBoard fboard, HttpSession session) {
		String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources\\img";
		fileService.insert(fboard, uploadFolder);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("lists", fileService.list());
		return "/file/list";
	}
}
