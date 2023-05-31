package com.javaex.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class RboardVO {

	private int no;
	private int userNo;
	private String title;
	private String name;
	private String content;
	private int hit;
	private Date regDate;
	private int groupNo;
	private int orderNo;
	private int depth;
	
	
	public RboardVO() {
		super();
	}


	public RboardVO(int no, int userNo, String title, String name, String content, int hit, Date regDate, int groupNo,
			int orderNo, int depth) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.title = title;
		this.name = name;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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


	public int getGroupNo() {
		return groupNo;
	}


	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	@Override
	public String toString() {
		return "RboardVO [no=" + no + ", userNo=" + userNo + ", title=" + title + ", name=" + name + ", content="
				+ content + ", hit=" + hit + ", regDate=" + regDate + ", groupNo=" + groupNo + ", orderNo=" + orderNo
				+ ", depth=" + depth + "]";
	}

	
}
