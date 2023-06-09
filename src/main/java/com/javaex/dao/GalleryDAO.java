package com.javaex.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.GalleryVO;

@Repository
public class GalleryDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVO> getGalleryList(){
		System.out.println("GalleryDAO getGalleryList()");
		
		List<GalleryVO> galleryList = sqlSession.selectList("gallery.getgallerylist");
		
		return galleryList;
	}
	
	public GalleryVO getGallery(GalleryVO vo) {
		System.out.println("GalleryDAO getGallery()");
		
		GalleryVO gallery = sqlSession.selectOne("gallery.getgallery",vo);
		
		return gallery;
	}
	
	public int insertGallery(GalleryVO vo) {
		System.out.println("GalleryDAO insertGallery()");
		
		return sqlSession.insert("gallery.insertgallery",vo);
	}
	

	public int deleteGallery(int no) {
		System.out.println("GalleryDAO deleteGallery()");
	
		return sqlSession.delete("gallery.deletegallery",no);
		
	}
}
