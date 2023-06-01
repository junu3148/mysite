package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RboardDAO;
import com.javaex.vo.RboardVO;

@Service
public class RboardService {

	@Autowired
	private RboardDAO rboardDAO;
	@Autowired
	private RboardVO rboardVO;

	// ----------------- getRboardList -----------------------------
	public List<RboardVO> getRboardList() {
		System.out.println("Service getBoardList()");

		List<RboardVO> boardList = rboardDAO.getRboardList();

		return boardList;

	}

	// ----------------- insertRboard -----------------------------
	public int insertRboard(RboardVO vo) {
		System.out.println("Service  insertRboard()");

		return rboardDAO.insertRboard(vo);

	}
	// ----------------- insertRboardComm -----------------------------
	public int insertRboardComm(RboardVO vo) {
		System.out.println("Service  insertRboardComm()");
		rboardDAO.updateRboardComm(vo);
		
		return rboardDAO.insertRboardComm(vo);
		
	}

	// ----------------- deleteRboard -----------------------------
	public int deleteRboard(RboardVO vo) {
		System.out.println("Service  deleteRboard()");

		return rboardDAO.deleteRboard(vo);

	}

	// ----------------- modifyRboard -----------------------------
	public RboardVO modifyRboard(RboardVO vo) {
		System.out.println("Service modifyRboard()");

		rboardVO = rboardDAO.getRboard(vo);
		
		rboardDAO.hitPlus(vo);

		return rboardVO;

	}

	// ----------------- updateRboard -----------------------------
	public int updateRboard(RboardVO vo) {
		System.out.println("Service updateRboard()");

		return rboardDAO.updateRboard(vo);

	}

}// Class End
