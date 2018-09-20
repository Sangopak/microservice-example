package com.sango.microservice.microservice.domain;

import java.util.Date;

public class PostV1 {
	private Date postDate;
	private String postText;
	private String postSource;

	public PostV1() {
		// TODO Auto-generated constructor stub
	}

	public PostV1(Date postDate, String postText, String postSource) {
		super();
		this.postDate = postDate;
		this.postText = postText;
		this.postSource = postSource;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostSource() {
		return postSource;
	}

	public void setPostSource(String postSource) {
		this.postSource = postSource;
	}
	
	
}
