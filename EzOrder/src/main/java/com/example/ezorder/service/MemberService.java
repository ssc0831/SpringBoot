package com.example.ezorder.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ezorder.model.Member;
import com.example.ezorder.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	public void saveMember(String memberName) {
		memberRepository.save(new Member(memberName));
	}
	
	@Transactional
	public void updatefcmToken(Member member) {
		Member m = findByMemberName(member.getMemberName());
		m.setFcmToken(member.getFcmToken());
	}
	
	public Member findByMemberName(String memberName) {
		return memberRepository.findByMemberName(memberName);
	}

}
