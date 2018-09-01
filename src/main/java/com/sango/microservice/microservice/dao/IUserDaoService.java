package com.sango.microservice.microservice.dao;

import java.util.List;

import com.sango.microservice.microservice.domain.User;

public interface IUserDaoService {

	public List<User> getUsers();
	public User getUserById(int id);
	public User addUser(User user);

}
