package com.sango.microservice.microservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sango.microservice.microservice.dao.IUserDaoService;
import com.sango.microservice.microservice.domain.User;

@RestController
public class UserResource {
	
	@Autowired
	private IUserDaoService userDaoService;

	@GetMapping(path="/users",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(){
		return userDaoService.getUsers();
	}
	
	@GetMapping(path="/users/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable final Integer id) {
		return userDaoService.getUserById(id);
	}
	
	@PostMapping(path="/users",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addUser (@RequestBody User user) {
		User newUser = userDaoService.addUser(user);
	}
	
	@DeleteMapping(path="/users/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> deleteUser (@PathVariable final Integer id) {
		return userDaoService.deleteUserById(id);
	}
}
