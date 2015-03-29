package com.niedson.votebook;

import java.util.List;

import com.niedson.votebook.model.spring.SpringApplicationContext;
import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.entity.Book;

	public class StartApp {
	
	public static void main(String[] args) throws Exception {
		Book book = new Book();
		book.setName("Senhor dos Aneis");
		
		BookDAO bookDAO = SpringApplicationContext.DAO.getBookDAO();
		Long id = bookDAO.save(book);
		System.out.println("Id: " + id);
		
		List<Book> listAll = bookDAO.listAll();
		System.out.println("Count: " + listAll.size());
		for (Book book2: listAll) {
			System.out.println("Book name:" + book2.getName());
		}
         
        SpringApplicationContext.closeApplicationContext();
	}
	
}
