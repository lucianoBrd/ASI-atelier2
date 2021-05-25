package com.sp.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String surname;
	private String password;
	private int solde = 5000;
	private String token;
	
	public User() {	
	}
	
	public User(int id, String name,String surname,String password) {
		super();
		this.id = id;
		this.setName(name);
		this.setSurname(surname);
		this.setPassword(password);
		
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

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public void createToken() {
		this.setToken(String.valueOf((this.getName() + this.getPassword() + "paulpaul" + this.getSurname() + this.getSolde()).hashCode()));
	}
	
}
