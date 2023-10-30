package com.example.oceandb.controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadController {
	
	@GetMapping("/upload")
    public void uploadImage() {
		return ;
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("image") MultipartFile file) {
    	return ;
    }
}
