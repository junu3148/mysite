package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;
import com.javaex.vo.Criteria;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private BoardVO boardVO;

	// ----------------- insertBoard -----------------------------
	public int insertBoard(BoardVO vo) {
		System.out.println("DAO insertBoard()");

		return sqlSession.insert("board.insertBoard", vo);

	}

	// ----------------- getBoardList -----------------------------
	public List<BoardVO> getBoardList(Criteria cri) {
		System.out.println("DAO getBoardList()");

		List<BoardVO> boardList = sqlSession.selectList("board.getBoardList",cri);

		return boardList;

	}

	// ----------------- getBoard -----------------------------
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("DAO getBoard()");

		boardVO = sqlSession.selectOne("board.getBoard", vo);

		return boardVO;

	}

	// ----------------- serchBoardList -----------------------------
	public List<BoardVO> serchBoardList(String title) {
		System.out.println("DAO serchBoardList()");

		List<BoardVO> boardList = sqlSession.selectList("board.serchBoardList", title);

		return boardList;

	}

	// ----------------- deleteBoard -----------------------------
	public int deleteBoard(BoardVO vo) {
		System.out.println("DAO deleteBoard()");

		return sqlSession.delete("board.deleteBoard", vo);

	}

	// ----------------- updateBoard -----------------------------
	public int updateBoard(BoardVO vo) {
		System.out.println("DAO updateBoard()");
				
		return sqlSession.update("board.updateBoard", vo);

	}

	// ----------------- hitPlus -----------------------------
	public int hitPlus(BoardVO vo) {
		System.out.println("DAO hitPlus()");

		return sqlSession.update("board.hitPlus", vo);

	}

}
