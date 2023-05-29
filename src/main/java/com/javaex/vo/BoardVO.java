package com.javaex.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class BoardVO {

	private int no;
	private String title;
	private String name;
	private int hit;
	private Date regDate;
	private String content;
	private int userNo;
	
	
	
	public BoardVO() {
		super();
	}
	public BoardVO(int no, String title, String name, int hit, Date regDate, String content, int userNo) {
		super();
		this.no = no;
		this.title = title;
		this.name = name;
		this.hit = hit;
		this.regDate = regDate;
		this.content = content;
		this.userNo = userNo;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", name=" + name + ", hit=" + hit + ", regDate=" + regDate
				+ ", content=" + content + ", userNo=" + userNo + "]";
	}
	
}
