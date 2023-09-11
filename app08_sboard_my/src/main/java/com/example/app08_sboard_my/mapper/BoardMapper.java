package com.example.app08_sboard_my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.app08_sboard_my.dto.Board;

@Mapper
public interface BoardMapper {

	//전체보기
	@Select("select * from board")
	public List<Board> list();
	//추가
	@Insert("insert into board(title, content) values(#{title}, #{content})")
	@Options(useGeneratedKeys = true, keyProperty = "num")
	public void insert(Board board);
	
}
