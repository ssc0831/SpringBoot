package com.example.demo03.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MemberShipCard {
	@Id
	private String cardNumber;
	private Date expiryDate;
	private boolean enabled;
	@JoinColumn(name = "user_email")
	@OneToOne
	private User user;
}
