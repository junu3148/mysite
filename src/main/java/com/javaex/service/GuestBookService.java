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
	@Autowired
	private GuestBookVO guestBookVO;

	// ------------------------ addList ---------------------------------
	public int addList(GuestBookVO vo) {
		System.out.println("Service addList()");

		return guestBookDAO.addList(vo);
	}

	// ------------------------ addList ---------------------------------
	public GuestBookVO addGuest(GuestBookVO vo) {
		System.out.println("Service addGuest()");
		
		int cont = guestBookDAO.addGuest(vo); // 인서트 성공시 넘어오는 int 값으로 예외처리하기위한 리턴값
		
		int num =  vo.getBoardId(); 
			
		return guestBookDAO.getGuestBook(num);
	}

	// ---------------------- getGuestBookList -------------------------------
	public List<GuestBookVO> getGuestBookList() {
		System.out.println("Service getGuestBookList()");

		List<GuestBookVO> guestBookList = guestBookDAO.getGuestBookList();

		return guestBookList;
	}

	// ------------------------ deleteGuestBook ---------------------------------
	public int deleteGuestBook(GuestBookVO vo) {
		System.out.println("Service deleteGuestBook()");

		return guestBookDAO.deleteGuestBook(vo);
	}
}
