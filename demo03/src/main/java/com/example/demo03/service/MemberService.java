package com.example.demo03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo03.model.JpaMember;
import com.example.demo03.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
//	@Autowired
//	private MemberRepository memberRepository;
	private final MemberRepository memberRepository;
	// 추가
	public void insert(JpaMember member) {
		memberRepository.save(member);
	}
	
	// 전체보기
	public List<JpaMember> list() {
		return memberRepository.findAll();
	}
	
	// 상세보기 select * from jpa_member where id = 1
	public JpaMember view(Long id) {
		return memberRepository.findById(id).get();
	// -> try~catch, Optional을 써도 됨.
	}
	
	// 삭제
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	// 수정(Dirty Checking)
	@Transactional
	public void update(JpaMember member) {
		JpaMember m = memberRepository.findById(member.getId()).get();
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setName(member.getName());
		m.setPassword(member.getPassword());
	}
}
