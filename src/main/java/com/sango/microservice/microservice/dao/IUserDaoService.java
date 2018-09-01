package com.sango.microservice.microservice.dao;

import java.util.List;

import com.sango.microservice.microservice.domain.Users;

public interface IUserDaoService {

	public List<Users> getUsers();

}
