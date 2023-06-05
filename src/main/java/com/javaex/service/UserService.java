package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDAO;
import com.javaex.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserVO userVO;

	// ------------------- inserUser -----------------------
	public int insertUser(UserVO vo) {
		System.out.println("Service insertUser");

		return userDAO.insertUser(vo);
	}
	// ------------------- idCheck -----------------------
	public boolean idCheck(String id) {
		System.out.println("Service idCheck");
		
		boolean result = true;
		userVO = userDAO.selectUser(id);
		if (userVO != null && id.equals(userVO.getId())) {
			result = false;
		}
		return result;
	}
	
	// ------------------- loginUser -----------------------
		public UserVO loginUser(UserVO vo) {
			System.out.println("Service loginUser");
			this.userVO = userDAO.loginUser(vo);
			return this.userVO;
		}

	// ------------------- getUser -----------------------
	public UserVO getUser(UserVO vo) {
		System.out.println("Service getUser");
		this.userVO = userDAO.getUser(vo);
		return this.userVO;
	}
	
	// ------------------- updatetUser -----------------------
		public int updateUser(UserVO vo) {
			System.out.println("Service updateUser");

			return userDAO.updateUser(vo);
		}

}
