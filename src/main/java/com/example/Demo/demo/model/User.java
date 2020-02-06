package com.example.Demo.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User implements Comparable< User > {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@JsonIgnore
	@Column(name="ID")
	private int id;
	
	@Column(name="FIRST_NAME")
	private String fisrtName;
	
	@Column(name="LAST_NAME")
	private String lastname;
	
	@Column(name="EMAIL",unique = true)
	private String email;
	
	@Column(name="Password")
	private String password;
	
	
	public User() {
		
	}


	public User(int id, String fisrtName, String lastname, String email,String password) {
		super();
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastname = lastname;
		this.email = email;
		this.password=password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFisrtName() {
		return fisrtName;
	}


	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int compareTo(User arg0) {
		
		return this.getFisrtName().compareTo(arg0.getFisrtName());
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

}
