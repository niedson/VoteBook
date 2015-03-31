package com.niedson.votebook.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niedson.votebook.persistence.dao.UserDAO;
import com.niedson.votebook.persistence.entity.User;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User save(User user){
		User savedUser  = userDAO.save(user);
		return savedUser;
	}
	
	public List<User> listAll(){
		return userDAO.listAll();
	}
	
	public User get(Long id) {
		return userDAO.get(id);
	}
	
	public User findByNameAndEmail(String name, String email) {
		return userDAO.findByNameAndEmail(name, email);
	}
	
	public User findUserByNameAndEmailOrCreate(String name, String email) {
		User userByNameAndEmail = userDAO.findByNameAndEmail(name, email);
		User user = new User();
		
		if (userByNameAndEmail == null) {
			user = new User(name, email);
		    user = this.save(user);
		} else {
			user = userByNameAndEmail;
		}
		return user;
	}
	
	
}
