package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaex.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private UserVO userVO;
	//------------------- inserUser -----------------------
	public int insertUser(UserVO vo) {
		System.out.println("DAO insertUser");
		
		return sqlSession.insert("user.insertUser", vo);
	}
	// ------------------- idCheck -----------------------
	public UserVO selectUser(String id) {
		System.out.println("DAO selectUser");
		 	
		return sqlSession.selectOne("user.selectUserByid", id);
	}
	
	//------------------- loginUser -----------------------
	public UserVO loginUser(UserVO vo) {
		System.out.println("DAO loginUser");
		this.userVO = sqlSession.selectOne("user.loginUser", vo);
		
		return this.userVO;
	}

	//------------------- getUser -----------------------
	public UserVO getUser(UserVO vo) {
		System.out.println("DAO getUser");
		this.userVO = sqlSession.selectOne("user.getUser", vo);
		
		
		return this.userVO;
	}
	//------------------- updatetUser -----------------------
		public int updateUser(UserVO vo) {
			System.out.println("DAO updateUser");
			
			return sqlSession.update("user.updateUser", vo);
		}
}
