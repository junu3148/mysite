package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVO;

@Repository
public class GuestBookDAO {

	@Autowired
	private SqlSession sqlSession;

	//------------------------ addList ---------------------------------
	public int addList(GuestBookVO vo) {
		System.out.println("DAO addList");
		
		return sqlSession.insert("guestbook.addList", vo);
	}
	
	//------------------------ addList ---------------------------------
	public int addGuest(GuestBookVO vo) {
		System.out.println("DAO addGuest()");
						
		int cont = sqlSession.insert("guestbook.apiaddList", vo);
		
		return cont;
	}
	
	// ---------------------- getGuestBook -------------------------------
		public GuestBookVO getGuestBook(int num) {
			System.out.println("DAO getGuestBookList()");
			
			GuestBookVO guestBook = sqlSession.selectOne("guestbook.getGuestBook",num);

			return guestBook;
		}

	// ---------------------- getGuestBookList -------------------------------
	public List<GuestBookVO> getGuestBookList() {
		System.out.println("DAO getGuestBookList()");
		
		List<GuestBookVO> guestBookList = sqlSession.selectList("guestbook.getGuestBookList");

		return guestBookList;
	}
	
	//------------------------ deleteGuestBook ---------------------------------
	public int deleteGuestBook(GuestBookVO vo) {
		System.out.println("DAO deleteGuestBook()");
		 	
		return sqlSession.delete("guestbook.deleteGuestBook", vo);
	}
}
