package com.sango.microservice.microservice.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="t_user")
@ApiModel(description="Stupid details of Users!!")
//@JsonFilter(value="dynamic-dob-filter")  //Enable for dynamic Filters
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes="System generated number")
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Size(min=2,message="Name should be atleast two char")
	@ApiModelProperty(notes="Name should be atleast two char")
	@Column(name="name")
	private String name;
	
	@Past(message="DOB should be in past")
	@ApiModelProperty(notes="DOB should be in past")
	@Column(name="dob")
	private Date dob;
	
	@JsonIgnore 										//Static Filtering
	@Column(name="ssn")
	private Long ssn;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, Date dob, Long ssn) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.ssn = ssn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
