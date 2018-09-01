package com.sango.microservice.microservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sango.microservice.microservice.domain.Users;

@Service
public class UserDaoServiceImpl implements IUserDaoService {

	private static List<Users> userList = new ArrayList<Users>();
	
	static {
		userList.add(new Users(1,"Subho", new Date()));
		userList.add(new Users(2,"Pupu", new Date()));
	}
	
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return userList;
	}

}
