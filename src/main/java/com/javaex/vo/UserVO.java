package com.javaex.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserVO {
	
	private int no;
	private String id;
	private String password;
	private String name;
	private String gender;
	

}
