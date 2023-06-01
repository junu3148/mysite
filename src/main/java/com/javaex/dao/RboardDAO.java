package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;
import com.javaex.vo.Criteria;
import com.javaex.vo.RboardVO;

@Repository
public class RboardDAO {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private RboardVO rboardVO;

	// ----------------- getRboardList -----------------------------
	public List<RboardVO> getRboardList(Criteria cri) {
		System.out.println("DAO getRboardList()");

		List<RboardVO> rboardList = sqlSession.selectList("rboard.getRboardList",cri);

		return rboardList;

	}

	// ----------------- getTotal -----------------------------
		public int getTotal(Criteria cri) {
			System.out.println("DAO getTotal()");
			
			return sqlSession.selectOne("rboard.getTotal",cri);
			
		}
	// ----------------- insertRboard -----------------------------
	public int insertRboard(RboardVO vo) {
		System.out.println("DAO  insertRboard()");

		return sqlSession.insert("rboard.insertRboard", vo);

	}
	// ----------------- insertRboardComm -----------------------------
	public int insertRboardComm(RboardVO vo) {
		System.out.println("DAO  insertRboardComm()");
		System.out.println(vo);
				
		return sqlSession.insert("rboard.insertRboardComm", vo);
		
	}

	// ----------------- deleteRboard -----------------------------
	public int deleteRboard(RboardVO vo) {
		System.out.println("DAO deleteRboard()");

		return sqlSession.delete("rboard.deleteRboard", vo);

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

		return sqlSession.update("rboard.updateRboard", vo);

	}
	// ----------------- updateRboard -----------------------------
	public int updateRboardComm(RboardVO vo) {
		System.out.println("DAO updateRboardComm()");
		
		return sqlSession.update("rboard.updateRboardComm", vo);
		
	}
	
	// ----------------- hitPlus -----------------------------
	public int hitPlus(RboardVO vo) {
		System.out.println("DAO hitPlus()");

		return sqlSession.update("rboard.hitPlus", vo);

	}

}
