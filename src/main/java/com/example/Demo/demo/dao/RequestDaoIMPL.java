package com.example.Demo.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Demo.demo.model.Product;
import com.example.Demo.demo.model.Request;
import com.example.Demo.demo.model.User;

@Repository
public class RequestDaoIMPL implements RequestDao {
	
    @PersistenceContext
	private EntityManager em;
	
	@Autowired
	public RequestDaoIMPL(EntityManager entityManager) {
		em=entityManager;
	}
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	public Request findRequestByUserID(int id) {
		
		return null;
	}

	@Override
	@Transactional
	public void saveRequest(Request request) {
		User u=userDao.findUserByID(request.getUser().getId());
		Product p=productDao.findProductByID(request.getProduct().getId());
		request.setProduct(p);
		request.setUser(u);
		em.persist(request);
	}

}
