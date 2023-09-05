package com.example.androidphone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.androidphone.model.Phone;
import com.example.androidphone.repository.PhoneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PhoneService {
	private final PhoneRepository phoneRepository;
	
	
	// 추가
	public Phone save(Phone phone) {
		return phoneRepository.save(phone);		
	}
	
	// 전체보기
	public List<Phone> findAll(){
		return phoneRepository.findAll();
	}
	
	// 삭제
	public void deleteById(long id) {
		phoneRepository.deleteById(id);
	}
	
	// 수정
	@Transactional
	public Phone update(long id, Phone phone) {
		Phone updatePhone = phoneRepository.findById(id).get();
		updatePhone.setName(phone.getName());
		updatePhone.setTel(phone.getTel());
		return updatePhone;
	}
}
