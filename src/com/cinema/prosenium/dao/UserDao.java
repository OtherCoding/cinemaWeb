package com.cinema.prosenium.dao;

import com.cinema.prosenium.entity.User;

public interface UserDao {
	User queryUser(User user);

	int addUser(User user);
}
