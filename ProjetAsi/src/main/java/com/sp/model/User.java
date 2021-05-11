package com.sp.model;

public class User {
	private String name;
	private String surname;
	private String password;
	public User() {	
	}
	public User(String name,String surname,String password) {
		super();
		this.setName(name);
		this.setSurname(surname);
		this.setPassword(password);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
