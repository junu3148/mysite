package com.javaex.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDAO;
import com.javaex.vo.GalleryVO;

@Service
public class GalleryService {

	String saveDir = "C:/javaStudy/upload/";
	@Autowired
	private GalleryDAO galleryDAO;

	public List<GalleryVO> getGalleryList() {
		System.out.println("GalleryService getGalleryList()");

		List<GalleryVO> galleryList = galleryDAO.getGalleryList();

		return galleryList;
	}

	public GalleryVO getGallery(GalleryVO vo) {
		System.out.println("GalleryService getGallery()");
		
		GalleryVO gallery = galleryDAO.getGallery(vo);
		
		return gallery;
	}
	
	// 파일저장위치 정보 업로드
	public int insertGallery(MultipartFile file, GalleryVO vo) {
		System.out.println("FileUploadService fileUpload()");

		// 오리지널파일
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: " + orgName);

		// 확장자
		String exName = orgName.substring(orgName.indexOf("."));
		System.out.println("exName: " + exName);

		// 저장파일 이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);

		// 파일패스
		String filePath = saveDir + saveName;
		System.out.println(filePath);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println("파일사이즈" + fileSize);

		// 파일 업로드(HDD save)
		if (!file.isEmpty()) {
			try {
				file.transferTo(new File(filePath));
				vo.setFilePath(filePath);
				vo.setOrgName(orgName);
				vo.setSaveName(saveName);
				vo.setFileSize((int)fileSize);
		
				galleryDAO.insertGallery(vo);
				
			} catch (IOException e) {
				// 파일 처리 중 예외가 발생한 경우 예외 처리 로직을 추가합니다.
				System.out.println("Error occurred while uploading file.");
				e.printStackTrace();
			}
			// fileUploadDAO.fileUpload(file);
		} else {
			// 업로드된 파일이 없는 경우에 대한 처리를 수행합니다.
			System.out.println("No file uploaded.");
		}

		// 파일 업로드가 실패하거나 예외가 발생한 경우에는 적절한 응답을 반환합니다.
		return 0;

	}

	public int deleteGallery(GalleryVO vo) {
		System.out.println("GalleryService deleteGallery()");

		return galleryDAO.deleteGallery(vo);
	}

}
