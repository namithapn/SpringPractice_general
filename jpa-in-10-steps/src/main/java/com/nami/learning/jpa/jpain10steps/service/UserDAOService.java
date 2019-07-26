package com.nami.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nami.learning.jpa.jpain10steps.entity.User;
//declarative transaction
@Repository
@Transactional
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	public long insert(User user){
		entityManager.persist(user);
		return user.getId();
	}

}
