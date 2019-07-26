package com.nami.learning.jpa.jpain10steps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String roll;
	
	
	
	public User() {
		super();
	}
	public User(String name, String roll) {
		super();
		this.name = name;
		this.roll = roll;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRoll() {
		return roll;
	}
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, roll=%s]", id, name, roll);
	}
	

}
