package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.FileUploadDAO;
import com.javaex.vo.FileVO;

@Service
public class FileUploadService {
	
	@Autowired
	public FileUploadDAO fileUploadDAO;
	
	//파일저장위치 정보 업로드
	public int fileUpload(String file) {
		System.out.println("FileUploadService fileUpload()");
		
		fileUploadDAO.fileUpload(file);
		
		return 0;
	}
	
	//파일저장위치 가져오기
	public List<FileVO> getFileList() {
		System.out.println("FileUploadService getFileList()");
		
		List<FileVO> fileList = fileUploadDAO.getFileList();
		
		return fileList;
	}

}
