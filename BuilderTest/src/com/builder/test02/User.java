package com.builder.test02;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class User {
	private String name;
	private int age;
}
