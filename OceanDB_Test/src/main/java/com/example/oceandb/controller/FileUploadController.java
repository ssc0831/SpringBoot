package com.example.oceandb.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	String UPLOADPATH = "C:\\SpringBoot_works\\OceanDB_Test\\src\\main\\resources\\UploadFile\\";
	
	@GetMapping("/upload")
	public void uploadImage() {
		return;
	}

	@PostMapping("/upload")
	public String uploadImage(@RequestParam("image") MultipartFile image) {
		if (image != null) {
			
			try {
				// 이미지를 저장할 경로 설정
				
				String fileName = image.getOriginalFilename();
				File targetFile = new File(UPLOADPATH + fileName);

				// 이미지를 서버에 저장
				image.transferTo(targetFile);
				System.out.println("file");
				return "Image uploaded successfully!";
			} catch (IOException e) {
				return "Error uploading image: " + e.getMessage();
			}
		} else {
			return "No image provided.";
		}
		
	}
	
//	public String uploadImages(MultipartFile file) {
//	      UUID uuid = UUID.randomUUID();
//	      String uploadFileName = "";
//	      
//	      if(!file.isEmpty()) {
//	         uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();
//	         File saveFile = new File(UPLOADPATH,uploadFileName);
//	         try {
//	            file.transferTo(saveFile);
//	         } catch (IllegalStateException | IOException e) {
//	            e.printStackTrace();
//	         }
//	      }
//	      return uploadFileName;
//	   }
	
	public String uploadImages(MultipartFile file) {
	    UUID uuid = UUID.randomUUID();
	    String uploadFileName = "";

	    if (!file.isEmpty()) {
	        uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();
	        File saveFile = new File(UPLOADPATH, uploadFileName);
	        try {
	            file.transferTo(saveFile);
	        } catch (IllegalStateException | IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // 상괭이 이름을 출력하도록 수정
	    return "상괭이";
	    
	}
}