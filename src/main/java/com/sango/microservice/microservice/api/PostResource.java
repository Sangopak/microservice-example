package com.sango.microservice.microservice.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sango.microservice.microservice.dao.UserRepository;
import com.sango.microservice.microservice.domain.Post;
import com.sango.microservice.microservice.domain.PostDetail;
import com.sango.microservice.microservice.domain.PostV1;
import com.sango.microservice.microservice.domain.PostV2;
import com.sango.microservice.microservice.domain.User;
import com.sango.microservice.microservice.exception.UserNotFoundException;
import com.sango.microservice.microservice.exception.UserPostNotFoundException;

@RestController
public class PostResource {
	
	@Autowired
	private UserRepository userRepoitory;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> getUserPosts(@PathVariable final Integer id){
		Optional<User> userOptional = userRepoitory.findById(id);
		
		if( ! userOptional.isPresent()) {
			throw new UserNotFoundException(messageSource.getMessage("error.user.not.found",null,LocaleContextHolder.getLocale())+":"+id);
		}
		return userOptional.get().getPosts();
	}
	
	@GetMapping(path="/users/{id}/posts/{postId}")
	public Post getUserPostsById(@PathVariable final Integer id, @PathVariable final Integer postId){
		Optional<User> userOptional = userRepoitory.findById(id);
		
		if( ! userOptional.isPresent()) {
			throw new UserNotFoundException(messageSource.getMessage("error.user.not.found",null,LocaleContextHolder.getLocale())+":"+id);
		}
		Post userPost = null;
		for(Post post : userOptional.get().getPosts()) {
			if (post.getId().intValue() == postId.intValue()) {
				userPost = post;
				break;
			}
		}	
		if(userPost == null) {
			throw new UserPostNotFoundException(messageSource.getMessage("error.user.post.not.found",null,LocaleContextHolder.getLocale())+":"+postId);
		}
		return userPost;
	}	
	
	//URI Versioning //could lead to URI pollution but easy to document, caching and can be executed from browser
	@GetMapping(path="/admin/v1/versioning/post")
	public PostV1 uriVersioningV1() {
		return new PostV1(new Date(),"Some Stupid FB post","FB");
	}
	
	@GetMapping(path="/admin/v2/versioning/post")
	public PostV2 uriVersioningV2() {
		return new PostV2(new PostDetail(new Date(), "Some Stupid FB post","FB", 666, 999));
	}
	
	//Parameter Versioning //could lead to URI pollution but easy to document and can be executed from browser
	@GetMapping(path="/admin/versioning/parm",params="ver=1")
	public PostV1 parmVersioningV1() {
		return new PostV1(new Date(),"Some Stupid FB post","FB");
	}
	
	@GetMapping(path="/admin/versioning/parm",params="ver=2")
	public PostV2 parmVersioningV2() {
		return new PostV2(new PostDetail(new Date(), "Some Stupid FB post","FB", 666, 999));
	}

	//Header Versioning //No URI pollution but difficult to document, need some client app to add headers
	@GetMapping(path="/admin/versioning/header",headers="X-API-VERSION=1")
	public PostV1 headerVersioningV1() {
		return new PostV1(new Date(),"Some Stupid FB post","FB");
	}
	
	@GetMapping(path="/admin/versioning/header",headers="X-API-VERSION=2")
	public PostV2 headerVersioningV2() {
		return new PostV2(new PostDetail(new Date(), "Some Stupid FB post","FB", 666, 999));
	}
	
	//Produces or Accept or MIME Versioning //No URI pollution but difficult to document, need some client app to add headers
	@GetMapping(path="/admin/versioning/produces",produces="application/whatever-v1+json")
	public PostV1 producesVersioningV1() {
		return new PostV1(new Date(),"Some Stupid FB post","FB");
	}
	
	@GetMapping(path="/admin/versioning/produces",produces="application/whatever-v2+json")
	public PostV2 producesVersioningV2() {
		return new PostV2(new PostDetail(new Date(), "Some Stupid FB post","FB", 666, 999));
	}
}
