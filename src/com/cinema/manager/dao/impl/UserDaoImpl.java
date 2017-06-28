package com.cinema.manager.dao.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cinema.manager.dao.UserDao;
import com.cinema.prosenium.entity.User;
import com.cinema.util.DBHelper;

public class UserDaoImpl extends DBHelper implements UserDao {

	@Override
	public User queryUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.manager.mapping.userMapper.queryUser";
	
		User us = sqlSession.selectOne(stm, user);
		sqlSession.close();
		return us;
		
	}

	@Override
	public List<User> queryUserAll() {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.manager.mapping.userMapper.queryUserAll";
	
		List<User> userList = sqlSession.selectList(stm);
		sqlSession.close();
		return userList;
	}

	@Override
	public int addUser(User user) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.userMapper.addUser";
	
		int result = sqlSession.update(stm,user);
		sqlSession.close();
		return result;
	}

	@Override
	public int editorUser(User user) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.manager.mapping.userMapper.editorUser";
	
		int result = sqlSession.update(stm,user);
		sqlSession.close();
		return result;
	}


}
