package com.cinema.prosenium.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.cinema.prosenium.dao.UserDao;
import com.cinema.prosenium.entity.User;
import com.cinema.util.DBHelper;

public class UserDaoImpl extends DBHelper implements UserDao {

	@Override
	public User queryUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		String stm = "com.cinema.prosenium.mapping.userMapper.queryUser";
	
		User us = sqlSession.selectOne(stm, user);
		sqlSession.close();
		return us;
	}

	@Override
	public int addUser(User user) {
		SqlSession sqlSession = this.getSqlSession(true);
		String stm = "com.cinema.prosenium.mapping.userMapper.addUser";
		int i = sqlSession.update(stm, user);
		sqlSession.close();
		return i;
	}

}
