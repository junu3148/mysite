package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;
import com.javaex.vo.RboardVO;

@Repository
public class RboardDAO {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private RboardVO rboardVO;

	// ----------------- getRboardList -----------------------------
	public List<RboardVO> getRboardList() {
		System.out.println("DAO getRboardList()");

		List<RboardVO> rboardList = sqlSession.selectList("rboard.getRboardList");

		return rboardList;

	}

	// ----------------- insertRboard -----------------------------
	public int insertRboard(RboardVO vo) {
		System.out.println("DAO  insertRboard()");

		return sqlSession.insert("rboard.insertRboard", vo);

	}

	// ----------------- deleteRboard -----------------------------
	public int deleteRboard(RboardVO vo) {
		System.out.println("DAO deleteRboard()");

		return sqlSession.insert("rboard.deleteRboard", vo);

	}

	// ----------------- getRboard -----------------------------
	public RboardVO getRboard(RboardVO vo) {
		System.out.println("DAO getRboard()");

		rboardVO = sqlSession.selectOne("rboard.getRboard", vo);

		return rboardVO;

	}

	// ----------------- updateRboard -----------------------------
	public int updateRboard(RboardVO vo) {
		System.out.println("DAO updateRboard()");

		return sqlSession.insert("rboard.updateRboard", vo);

	}
	
	// ----------------- hitPlus -----------------------------
	public int hitPlus(RboardVO vo) {
		System.out.println("DAO hitPlus()");

		return sqlSession.update("rboard.hitPlus", vo);

	}

}
