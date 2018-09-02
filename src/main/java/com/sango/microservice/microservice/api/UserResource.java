package com.sango.microservice.microservice.api;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sango.microservice.microservice.dao.IUserDaoService;
import com.sango.microservice.microservice.domain.User;
import com.sango.microservice.microservice.exception.NoUsersFoundException;
import com.sango.microservice.microservice.exception.UserNotFoundException;

@RestController
public class UserResource {
	
	@Autowired
	private IUserDaoService userDaoService;

	@GetMapping(path="/users",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(){
		List<User> users = userDaoService.getUsers();
		if (users == null || users.size() == 0) {
			throw new NoUsersFoundException("No Users Found");
		}
		return users;
	}
	
	@GetMapping(path="/users/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable final Integer id) {
		User userById = userDaoService.getUserById(id);
		if (userById == null) {
			throw new UserNotFoundException("User not found id:"+id);
		}
		return userById;
	}
	
	@PostMapping(path="/users",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser (@RequestBody User user) {
		User newUser = userDaoService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@DeleteMapping(path="/users/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> deleteUser (@PathVariable final Integer id) {
		return userDaoService.deleteUserById(id);
	}
}
