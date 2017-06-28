package com.cinema.prosenium.serv;

import com.cinema.prosenium.entity.User;

public interface UserServ {
	User queryUser(User user);

	int addUser(User user);
}
