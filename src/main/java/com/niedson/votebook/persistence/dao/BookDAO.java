package com.niedson.votebook.persistence.dao;

import java.util.List;

import com.niedson.votebook.persistence.entity.Book;

public interface BookDAO {
	
	public Book save(Book book);
    public List<Book> listAll();
    public Book get(Long id);
    
}
