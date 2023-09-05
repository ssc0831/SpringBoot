package com.example.demo04.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo04.model.FileBoard;
import com.example.demo04.repository.FileRepository;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;
	public void insert(FileBoard fboard, String uploadFolder) {
		UUID uuid = UUID.randomUUID();
		MultipartFile f = fboard.getUpload();
		String uploadFileName="";
		if (!f.isEmpty()) { // 파일 선택됨
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename();
			File saveFile = new File(uploadFolder, uploadFileName);
			try {
				f.transferTo(saveFile);
				fboard.setFileimage(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} // 파일 업로드
		}
		fileRepository.save(fboard);
	}
	
	// 전체 보기
	public List<FileBoard> list() {
		return fileRepository.findAll();
	}
	
/////
	public void fileInsert(FileBoard fboard) {
		UUID uuid = UUID.randomUUID();
		MultipartFile f = fboard.getUpload();
		String uploadFileName="";
		if (!f.isEmpty()) { // 파일 선택됨
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename();
			File saveFile = new File(uploadFileName);
			try {
				f.transferTo(saveFile);
				fboard.setFileimage(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} // 파일 업로드
		}
		fileRepository.save(fboard);
	}
}
