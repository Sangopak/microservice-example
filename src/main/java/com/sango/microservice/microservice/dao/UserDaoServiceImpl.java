package com.sango.microservice.microservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sango.microservice.microservice.domain.User;

@Service
public class UserDaoServiceImpl implements IUserDaoService {

	private static List<User> userList = new ArrayList<User>();
	
	private static int userId = 2;
	
	//adding static block to mock DB layer
	static {
		userList.add(new User(1,"Subho", new Date()));
		userList.add(new User(2,"Pupu", new Date()));
	}
	
	@Override
	public List<User> getUsers() {
		return userList;
	}

	@Override
	public User getUserById(int id) {
		User result = null;
		for (User users : userList) {
			if (users.getId() != id) {
				continue;
			}else {
				result = users;
			}
		}
		return result;
	}

	@Override
	public User addUser(User user) {
		if(user.getId() == null ) {
			user.setId(++userId);
		}
		userList.add(user);		
		return user;
	}
	
	

}
