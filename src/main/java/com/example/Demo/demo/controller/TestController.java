package com.example.Demo.demo.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.demo.dao.ProductDao;
import com.example.Demo.demo.dao.RequestDao;
import com.example.Demo.demo.dao.UserDao;
import com.example.Demo.demo.model.Product;
import com.example.Demo.demo.model.Request;
import com.example.Demo.demo.model.User;

@RestController
public class TestController {
	@Autowired
	private UserDao userdao;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private RequestDao requestDao;
	
	public TestController() {
	
	} 

	@GetMapping("/time")
	public String sayHello() {
		
	return "Hello "+ LocalTime.now();	
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
	
		return userdao.findAll();
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productdao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUsers(@PathVariable int id){
		
		User user=userdao.findUserByID(id);
		if(user==null) {
			
			throw new RuntimeException("Employee not found");
		}
	
		return user ;
	}
	
	@PostMapping("/users")
	public User saveUsers(@RequestBody User user){
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		userdao.saveUser(user);
		return user;
	}
	
	@DeleteMapping("/users/delete/{id}")
	public String deleteUsers(@PathVariable int id){
		
		userdao.deleteUserByID(id);
		
		return id+" deleted";

	}
	
	@PutMapping(path="users/updateuser")
	public User updateUsers(@RequestBody User user){
		userdao.updateUser(user);
		return user; 
	}
	
	@PostMapping("/login")
	public User userAuth(@RequestBody User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		User u=userdao.userAuth(user);
		if(u.getEmail().equalsIgnoreCase(user.getEmail())&& passwordEncoder.matches(user.getPassword(), u.getPassword())) {
			return u;	
		}
		return null;
	}
	
	@PostMapping("/request")
	public Request saveRequest(@RequestBody Request request){
		requestDao.saveRequest(request);
		return request;
		
	}
	
}
