package com.sango.microservice.microservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sango.microservice.microservice.dao.IUserDaoService;
import com.sango.microservice.microservice.domain.Users;

@RestController
public class UserResource {
	
	@Autowired
	private IUserDaoService userDaoService;

	@GetMapping(path="/users",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users> getUsers(){
		return userDaoService.getUsers();
	}
}
