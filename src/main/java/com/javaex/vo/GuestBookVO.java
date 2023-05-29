package com.javaex.vo;

import java.sql.Date;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
public class GuestBookVO {

	private String name;
	private String pwd;
	private String content;
	private Date regDate;
	private int boardId;
	
	
	public GuestBookVO() {
		super();
	}


	public GuestBookVO(String name, String pwd, String content, Date regDate, int boardId) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.content = content;
		this.regDate = regDate;
		this.boardId = boardId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	@Override
	public String toString() {
		return "GuestBookVO [name=" + name + ", pwd=" + pwd + ", content=" + content + ", regDate=" + regDate
				+ ", boardId=" + boardId + "]";
	}
	
	
}
