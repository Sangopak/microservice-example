package com.sango.microservice.microservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sango.microservice.microservice.domain.User;

@Service
public class UserDaoServiceImpl implements IUserDaoService {

	private static List<User> userList = new ArrayList<User>();
	
	private static int userId = 1;
	
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

	@Override
	public List<User> deleteUserById(int id) {
		for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if(user.getId() == id) {
				iterator.remove();
			}
		}
		return userList;
	}
	
	

}
