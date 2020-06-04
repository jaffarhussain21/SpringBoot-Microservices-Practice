package org.spring.springjpademo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.spring.springjpademo.UserTable;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserServiceDAO {

	@PersistenceContext
	EntityManager entityManager;

	public long insert(UserTable user) {
		entityManager.persist(user);
		return user.getId();
	}

}
