package com.example.demo03.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	private String email;
	private String name;
	private Date createDate;
	@OneToOne(mappedBy = "user")
	private MemberShipCard card;
}
