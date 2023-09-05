package com.builder.test02;

import org.junit.Test;

public class UserBuilderTest02 {
	@Test
	public void builderTest02() {
		User user = User.builder()
				.name("홍길동")
				.age(22)
				.build();
		System.out.println(user);
		
		User user1 = User.builder()
				.age(44)
				.name("이자바")
				.build();
		System.out.println(user1);
	}
	
	

}

