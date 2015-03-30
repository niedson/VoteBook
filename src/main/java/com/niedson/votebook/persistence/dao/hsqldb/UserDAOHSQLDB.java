package com.niedson.votebook.persistence.dao.hsqldb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niedson.votebook.persistence.dao.UserDAO;
import com.niedson.votebook.persistence.entity.User;


@Repository
@Transactional
public class UserDAOHSQLDB implements UserDAO {
	
	@PersistenceContext
    private EntityManager em;

	public User save(User user) {
        em.persist(user);
        return user;
	}

	public List<User> listAll() {
		return em.createQuery("FROM User u", User.class).getResultList();
	}

	public User get(Long id) {
    	List<User> resultList = em.createQuery(" FROM User u WHERE u.id = " + id, User.class).getResultList();
    	return resultList.isEmpty() ? null : resultList.get(0);
	}

}
