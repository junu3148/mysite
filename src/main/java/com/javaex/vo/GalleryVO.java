package com.javaex.vo;

import org.springframework.stereotype.Component;

@Component
public class GalleryVO {
	
	private int no;
	private int userNo;
	private String content;
	private String filePath;
	private String orgName;
	private String savaName;
	private int fileSize ;
	
	public GalleryVO() {
		super();
	}

	public GalleryVO(int no, int userNo, String content, String filePath, String orgName, String savaName,
			int fileSize) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.savaName = savaName;
		this.fileSize = fileSize;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSavaName() {
		return savaName;
	}

	public void setSavaName(String savaName) {
		this.savaName = savaName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "GalleryVO [no=" + no + ", userNo=" + userNo + ", content=" + content + ", filePath=" + filePath
				+ ", orgName=" + orgName + ", savaName=" + savaName + ", fileSize=" + fileSize + "]";
	}
	
}
