package com.niedson.votebook.persistence.dao;

import java.util.List;

import com.niedson.votebook.persistence.entity.Book;

public interface BookDAO {
	
	public Long save(Book book);
    public List<Book> listAll();

}
