package com.nami.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Deatails About all users")
public class User {
	private Integer id;
	@Size(min = 2, message = "Name should have atleast 2 charecters")
	@ApiModelProperty(notes="Name should have atleast 2 charecters")
	private String name;
	@Past
	@ApiModelProperty(notes="birthdate should not be future date")
	private Date birthdate;
	
	
	
	protected User() {
		
	}
	public User(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
	
		this.name = name;
		this.birthdate = birthdate;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthdate=%s]", id, name, birthdate);
	}
	

}
