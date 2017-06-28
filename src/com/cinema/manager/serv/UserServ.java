package com.cinema.manager.serv;

import java.util.List;

import com.cinema.prosenium.entity.User;

public interface UserServ {

	User queryUser(User user);

	List<User> queryUserAll();

	int addUser(User user);

	int editorUser(User user);

}
