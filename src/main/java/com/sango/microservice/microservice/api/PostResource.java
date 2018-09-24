package com.sango.microservice.microservice.api;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sango.microservice.microservice.domain.PostDetail;
import com.sango.microservice.microservice.domain.PostV1;
import com.sango.microservice.microservice.domain.PostV2;

@RestController
public class PostResource {
	
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
