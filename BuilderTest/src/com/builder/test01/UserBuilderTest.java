package com.builder.test01;

import org.junit.Test;

public class UserBuilderTest {
	@Test
	public void userbuilderTest() {
	User user =	User.builder()
		.name("홍길동")
		.age(20)
		.build();
	System.out.println(user);
	
	User user1 = User.builder()
			.age(33)
			.name("이순신")
			.build();
	System.out.println(user1);
		
		
	}
}
