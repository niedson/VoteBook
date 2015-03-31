package com.niedson.votebook.persistence.dao.hsqldb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

	public User findByNameAndEmail(String name, String email) {
		
		try {	
			User result = em.createQuery(" "
					+ " FROM User u "
					+ " WHERE u.name = '" + name + "' "
					+ "   AND u.email = '" + email + "' ", User.class).getSingleResult();
			return result;
		
	    } catch(NoResultException e) {
	        return null;
	    }
	}
	
}
