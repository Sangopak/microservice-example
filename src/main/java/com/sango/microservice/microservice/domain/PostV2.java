package com.sango.microservice.microservice.domain;

public class PostV2 {
	private PostDetail postDetail;
	
	public PostV2() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PostV2(PostDetail postDetail) {
		super();
		this.postDetail = postDetail;
	}



	public PostDetail getPostDetail() {
		return postDetail;
	}

	public void setPostDetail(PostDetail postDetail) {
		this.postDetail = postDetail;
	}
	
	
}
