package com.cinema.manager.dao;

import java.util.List;

import com.cinema.prosenium.entity.User;

public interface UserDao {

	User queryUser(User user);

	List<User> queryUserAll();

	int addUser(User user);

	int editorUser(User user);

}
