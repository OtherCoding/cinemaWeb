package com.cinema.prosenium.serv.impl;

import com.cinema.prosenium.dao.UserDao;
import com.cinema.prosenium.dao.impl.UserDaoImpl;
import com.cinema.prosenium.entity.User;
import com.cinema.prosenium.serv.UserServ;

public class UserServImpl implements UserServ{
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User queryUser(User user) {
		return userDao.queryUser(user);
	}

	@Override
	public int addUser(User user) {
		
		return userDao.addUser(user);
	}
}
