package com.sango.microservice.microservice.domain;

import java.util.Date;

public class PostDetail {
	private Date postDate;
	private String postText;
	private String postSource;
	private int numberOfLikes;
	private int numberOfDisLikes;
	
	public PostDetail() {
		// TODO Auto-generated constructor stub
	}

	
	public PostDetail(Date postDate, String postText, String postSource, int numberOfLikes, int numberOfDisLikes) {
		super();
		this.postDate = postDate;
		this.postText = postText;
		this.postSource = postSource;
		this.numberOfLikes = numberOfLikes;
		this.numberOfDisLikes = numberOfDisLikes;
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

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public int getNumberOfDisLikes() {
		return numberOfDisLikes;
	}

	public void setNumberOfDisLikes(int numberOfDisLikes) {
		this.numberOfDisLikes = numberOfDisLikes;
	}
	
	

}
