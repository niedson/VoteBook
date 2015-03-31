package com.niedson.votebook.persistence.dao;

import java.util.List;

import com.niedson.votebook.persistence.entity.User;

public interface UserDAO {
	
	public User save(User user);
    public List<User> listAll();
    public User get(Long id);
    public User findByNameAndEmail(String name, String email); 

}
