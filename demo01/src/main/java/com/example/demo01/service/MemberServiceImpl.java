package com.example.demo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo01.dao.MemberMapper;
import com.example.demo01.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper mMapper;
	@Override
	public void join(MemberDTO member) {
	mMapper.join(member);
		
	}

	@Override
	public int idCheck(String id) {
		return mMapper.idCheck(id);
	}

	@Override
	public MemberDTO loginCheck(String id) {
		return mMapper.loginCheck(id);
	}

	@Override
	public void update(MemberDTO member) {
		mMapper.update(member);
	}

}

