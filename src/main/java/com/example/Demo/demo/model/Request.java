package com.example.Demo.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="Request_Desc")
	private String requestDescription;
	
    @OneToOne
    @JoinColumn(name="Product_ID")
    private Product product;
    
    @OneToOne
    @JoinColumn(name="User_ID")
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", requestDescription=" + requestDescription + ", product=" + product + "]";
	}

	public Request(int id, String requestDescription, Product product) {
		super();
		this.id = id;
		this.requestDescription = requestDescription;
		this.product = product;
	}

	public Request() {
		super();
	}

}
