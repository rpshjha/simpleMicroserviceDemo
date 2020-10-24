package com.rupesh.practice.springboot.CreateMicroservices.users;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	private Integer id;

	@Size(min=2, message = "name should contain atleast 2 characters")
	private String name;
	
	@Past(message= "birth date should be less than current date")
	private Date birthDate;
	
	protected User() {}

	public User(int id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthDate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthDate = birthdate;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthdate=" + birthDate + "]";
	}

}
