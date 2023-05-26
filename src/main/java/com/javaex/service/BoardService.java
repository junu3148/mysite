package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDAO;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private BoardVO boardVO;

	// ----------------- insertBoard -----------------------------
	public int insertBoard(BoardVO vo) {
		System.out.println("Service insertBoard()");

		return boardDAO.insertBoard(vo);

	}

	// ----------------- getBoardList -----------------------------
	public List<BoardVO> getBoardList() {
		System.out.println("Service getBoardList()");

		List<BoardVO> boardList = boardDAO.getBoardList();

		return boardList;

	}

	// ----------------- serchBoardList -----------------------------
	public List<BoardVO> serchBoardList(String title) {
		System.out.println("Service serchBoardList()");

		List<BoardVO> boardList = boardDAO.serchBoardList(title);

		return boardList;

	}

	// ----------------- modifyBoard -----------------------------
	public BoardVO modifyBoard(BoardVO vo) {
		System.out.println("Service modifyBoard()");

		boardVO = boardDAO.getBoard(vo);
		boardDAO.hitPlus(vo);

		return boardVO;

	}

	// ----------------- deleteBoard -----------------------------
	public int deleteBoard(BoardVO vo) {
		System.out.println("Service deleteBoard()");

		return boardDAO.deleteBoard(vo);

	}

	// ----------------- updateBoard -----------------------------
	public int updateBoard(BoardVO vo) {
		System.out.println("Service updateBoard()");

		return boardDAO.updateBoard(vo);

	}


}
