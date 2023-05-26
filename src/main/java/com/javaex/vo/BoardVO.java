package com.javaex.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BoardVO {

	private int no;
	private String title;
	private String name;
	private int hit;
	private Date regDate;
	private String content;
	private int userNo;
	
}
