package com.security.dao.impl;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.dao.UserDao;
import com.security.model.User;

@Repository
public class UserDaoImpl implements UserDao
{
	protected EntityManagerFactory entityManagerFactory;
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}



	@Override
	public void saveUser(List<User> userList) {
		System.out.println("dao-----");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		userList.forEach((a)->{
			em.persist(a);
		});
		em.getTransaction().commit();
	}



	@Override
	public void getAllUsers() {
		System.out.println("All Users....");
	List<User>	q= entityManagerFactory.createEntityManager()
			.createQuery("SELECT u FROM User u").getResultList();
	System.out.println(q.size()+"=size");
	q.forEach((a) ->{
		System.out.println(a.toString());
	});
		
	}



	@Override
	public User getUserById(User u) {
		System.out.println("===userName  : "+u.toString());
		User u1 = (User) entityManagerFactory.createEntityManager()
		.createQuery("SELECT u FROM User u Where u.userName = ?1 and u.password = ?2")
		.setParameter(1, u.getUserName())
		.setParameter(2, u.getPassword())
		.getSingleResult();
		
		System.out.println(u1.toString());
		return u1;
	}

}
