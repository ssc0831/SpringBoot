package com.example.demo01.dto;



import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String addr;
	private Date regdate;
}
