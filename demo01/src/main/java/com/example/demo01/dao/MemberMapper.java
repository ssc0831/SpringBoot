package com.example.demo01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo01.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	// 로그인 체크
	@Insert("insert into member(id, pass, name, addr, regdate)" + "values(#{id}, #{pass}, #{name}, #{addr}, now())")
	public void join(MemberDTO member);

	//아이디 중복확인
	@Select("select count(*) from member where id=#{id}")
	public int idCheck(String id);

	//로그인 체크
	@Select("select * from member where id=#{id}")
	public MemberDTO loginCheck(String id);

	//수정
	@Update("update member set name=#{name}, pass=#{pass}," + "addr=#{addr} where id=#{id}")
	public void update(MemberDTO member);
}
