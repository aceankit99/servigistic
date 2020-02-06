package com.example.Demo.demo.dao;

import com.example.Demo.demo.model.Request;

public interface RequestDao {
	
	public Request findRequestByUserID(int id);

	public void saveRequest(Request request);

}
