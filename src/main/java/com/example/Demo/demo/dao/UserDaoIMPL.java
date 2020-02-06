/**
 * 
 */
package com.example.Demo.demo.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Demo.demo.model.User;

/**
 * @author 40900466
 *
 */

@Repository
public class UserDaoIMPL implements UserDao {
	
    @PersistenceContext
	private EntityManager em;
	
	@Autowired
	public UserDaoIMPL(EntityManager entityManager) {
		em=entityManager;
	}


	@Override
	@Transactional
	public List<User> findAll() {
		Comparator<User> compareByFirstName = (User o1, User o2) ->o1.getFisrtName().compareTo(o2.getFisrtName());
		List<User> list =  em.createQuery("from User",User.class).getResultList();
		Collections.sort(list, compareByFirstName);
		return list;
	}


	@Override
	@Transactional
	public User findUserByID(int id) {
		User user=em.find(User.class, id);
		return user;
	}


	@Override
	@Transactional
	public void saveUser(User user) {
		em.persist(user);
		
	}


	@Override
	@Transactional
	public void deleteUserByID(int id) {
		Query query=em.createQuery("delete from User  where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}


	@Override
	@Transactional
	public void updateUser(User user) {
//		em.detach(user);
		em.merge(user);
		
	}


	@Override
	@Transactional
	public User userAuth(User user) {
		Query query=em.createQuery("select u from User u where u.email=:email");
		query.setParameter("email", user.getEmail());
		//query.setParameter("password", user.getPassword());
		List<User> list=query.getResultList();
		if(list.size()>0) {
			return list.get(0);
		}
		else {
		return null;
		}
	}
	

}
