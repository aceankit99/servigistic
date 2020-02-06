package com.example.Demo.demo.dao;

import java.util.List;
import com.example.Demo.demo.model.Product;

public interface ProductDao {

	public List<Product> findAll();
	
	public Product findProductByID(int id);
}
