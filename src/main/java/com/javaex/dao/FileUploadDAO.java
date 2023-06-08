package com.javaex.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVO;

@Repository
public class FileUploadDAO {
	
	@Autowired
	public SqlSession sqlSession;
	
	//파일저장위치 정보 업로드
	public int fileUpload(String file) {
		System.out.println("FileUploadDAO fileUpload()");
		System.out.println(file);
		
		//sqlSession.insert("fileupload.fileupload", file);
		
		return 0;
	}
	
	//파일저장위치 가져오기
	public List<FileVO> getFileList() {
		System.out.println("FileUploadDAO getFileList()");
		
		List<FileVO> fileList = new ArrayList<FileVO>();
		//List<FileVO> fileList = sqlSession.selectList("fileupload.getfilelist");
		
		return fileList;
	}

}
