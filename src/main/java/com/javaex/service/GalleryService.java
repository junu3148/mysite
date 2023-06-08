package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDAO;
import com.javaex.vo.GalleryVO;

@Service
public class GalleryService {

	@Autowired
	private GalleryDAO galleryDAO;

	public List<GalleryVO> getGalleryList() {
		System.out.println("GalleryService getGalleryList()");

		List<GalleryVO> galleryList = galleryDAO.getGalleryList();

		return galleryList;
	}

	public int insertGallery(MultipartFile file) {
		System.out.println("GalleryService insertGallery()");
		
		return 0;
	}
	

	public int deleteGallery(GalleryVO vo) {
		System.out.println("GalleryService deleteGallery()");
		
		return galleryDAO.deleteGallery(vo);
	}

}
