package com.sango.microservice.microservice.domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Stupid details of Users!!")
//@JsonFilter(value="dynamic-dob-filter")  //Enable for dynamic Filters
public class User {
	
	@ApiModelProperty(notes="System generated number")
	private Integer id;
	
	@Size(min=2,message="Name should be atleast two char")
	@ApiModelProperty(notes="Name should be atleast two char")
	private String name;
	
	@Past(message="DOB should be in past")
	@ApiModelProperty(notes="DOB should be in past")
	private Date dob;
	
	@JsonIgnore 										//Static Filtering
	private Long ssn;
	
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
	
	
}
