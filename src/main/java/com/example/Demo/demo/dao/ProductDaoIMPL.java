package com.example.Demo.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Demo.demo.model.Product;
import com.example.Demo.demo.model.User;

@Repository("productDao")
public class ProductDaoIMPL implements ProductDao {

    @PersistenceContext
	private EntityManager em;
	
	@Autowired
	public ProductDaoIMPL(EntityManager entityManager) {
		em=entityManager;
	}
	
	@Override
	@Transactional
	public List<Product> findAll() {
		List<Product> list=em.createQuery("from Product",Product.class).getResultList();
		return list;
	}

	@Override
	@Transactional
	public Product findProductByID(int id) {
	    Product product=em.find(Product.class, id);
	    return product;
	}

}
