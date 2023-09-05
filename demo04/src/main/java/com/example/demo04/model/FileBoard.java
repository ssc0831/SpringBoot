package com.example.demo04.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class FileBoard {
	// 번호 제목, 저자, 내용, 이미지
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String title;
	private String writer;
	private String content;
	@Transient
	private MultipartFile upload; // 업로드
	private String fileimage; // 테이블에 저장할 파일 이름
}
