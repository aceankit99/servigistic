package com.example.Demo.demo.dao;

import java.util.List;

import com.example.Demo.demo.model.User;

public interface UserDao {
	
	public List<User> findAll();
	
	public User findUserByID(int id);

	public void saveUser(User user);
	
	public void deleteUserByID(int  id);
	
	public void updateUser(User user);
	
	public User userAuth(User user);
}
