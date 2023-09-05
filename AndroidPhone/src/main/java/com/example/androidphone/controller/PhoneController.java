package com.example.androidphone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.androidphone.model.Phone;
import com.example.androidphone.service.PhoneService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PhoneController {
	private final PhoneService phoneService;
	//추가
	@PostMapping("/insert")
	public Phone insert(@RequestBody Phone phone) {
		return phoneService.save(phone);
	}
	//전체보기
	@GetMapping("/list")
	public List<Phone> selectAll(){
		return phoneService.findAll();
	}
	//수정
	@PutMapping("/update/{id}")
	public Phone update(@PathVariable long id, @RequestBody Phone phone) {
		return phoneService.update(id,phone);
	}
	//삭제
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) {
		phoneService.deleteById(id);
	}
}
