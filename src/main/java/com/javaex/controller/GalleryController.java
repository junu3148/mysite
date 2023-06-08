package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVO;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping(value="/list", method = {RequestMethod.GET,RequestMethod.POST})
	public String galleryList(Model moel) {
		System.out.println("galleryList()");
		
		List<GalleryVO> galleryList =galleryService.getGalleryList();
		
		//moel.addAttribute("galleryList", galleryList);
		
		return "/gallery/list";
	}
	
	@RequestMapping(value="/insert", method = {RequestMethod.GET,RequestMethod.POST})
	public String insertGallery(@RequestParam("file") MultipartFile file) {
		System.out.println("insertGallery()");
		
		galleryService.insertGallery(file);
		
		return "";
		
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public String deleteGallery(@ModelAttribute GalleryVO vo) {
		System.out.println("deleteGallery()");
		
		int result = galleryService.deleteGallery(vo);
		
		return "";
		
	}

}











