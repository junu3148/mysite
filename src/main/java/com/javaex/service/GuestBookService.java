package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDAO;
import com.javaex.vo.GuestBookVO;

@Service
public class GuestBookService {
	
	@Autowired
	private GuestBookDAO guestBookDAO;
	
	//------------------------ addList ---------------------------------
	public int addList(GuestBookVO vo) {
		System.out.println("Service addList()");
		
		return guestBookDAO.addList(vo);
	}

	//---------------------- getGuestBookList -------------------------------
	public List<GuestBookVO> getGuestBookList() {
		System.out.println("Service getGuestBookList()");
		
		List<GuestBookVO> guestBookList = guestBookDAO.getGuestBookList(); 
		
		return guestBookList;
	}
	
	//------------------------ deleteGuestBook ---------------------------------
	public int deleteGuestBook(GuestBookVO vo) {
		System.out.println("Service deleteGuestBook()");
		
		return guestBookDAO.deleteGuestBook(vo);
	}
}






