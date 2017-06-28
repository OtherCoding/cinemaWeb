package com.cinema.manager.serv.impl;

import java.util.List;

import com.cinema.manager.dao.UserDao;
import com.cinema.manager.dao.impl.UserDaoImpl;
import com.cinema.manager.serv.UserServ;
import com.cinema.prosenium.entity.User;

public class UserServImpl implements UserServ {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User queryUser(User user) {
		
		return userDao.queryUser(user);
	}
	@Override
	public List<User> queryUserAll() {
		
		return userDao.queryUserAll();
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	@Override
	public int editorUser(User user) {
		// TODO Auto-generated method stub
		return userDao.editorUser(user);
	}

}
