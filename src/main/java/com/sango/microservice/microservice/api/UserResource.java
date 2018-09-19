package com.sango.microservice.microservice.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
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
	private MessageSource messageSource;
	
	@Autowired
	private IUserDaoService userDaoService;

	@GetMapping(path="/users")
	//Dynamic Filtering using MappingJacksonValue
	public List<User> getUsers(){
		List<User> users = userDaoService.getUsers();		
		if (users == null || users.size() == 0) {
			throw new NoUsersFoundException(messageSource.getMessage("error.no.user.found",null,LocaleContextHolder.getLocale()));
		}
		
		// enable below sections with mappingJacksonValue to activate dynamic filter
		/*MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users); 
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamic-dob-filter", filter );
		mappingJacksonValue.setFilters(filters); */
		
		return users;
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> getUserById(@PathVariable final Integer id) {
		User userById = userDaoService.getUserById(id);
		if (userById == null) {
			throw new UserNotFoundException(messageSource.getMessage("error.user.not.found",null,LocaleContextHolder.getLocale())+":"+id);
		}
		ControllerLinkBuilder link = linkTo(methodOn(UserResource.class).getUsers());
		Resource<User> resource = new Resource<User>(userById);
		resource.add(link.withRel("all-users"));
		return resource;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> addUser (@RequestBody @Valid User user) {
		User newUser = userDaoService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@DeleteMapping(path="/users/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> deleteUser (@PathVariable final Integer id) {
		return userDaoService.deleteUserById(id);
	}
}
