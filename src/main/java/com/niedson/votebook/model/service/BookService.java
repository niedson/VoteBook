package com.niedson.votebook.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.persistence.entity.VoteBookHist;
import com.niedson.votebook.to.BookListId;

@Service
public class BookService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	private BookDAO bookDAO;
	
	@Autowired
	public BookService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public Book save(Book book){
		Book savedBook  = bookDAO.save(book);
		return savedBook;
	}
	
	public List<Book> listAll(){
		return bookDAO.listAll();
	}
	
	public Book get(Long id) {
		return bookDAO.get(id);
	}
	
	public List<BookListId> getNextBookPair(List<BookListId> bookListProbabilitySession) {
		List<BookListId> bookListProbability = new ArrayList<BookListId>();
		if (bookListProbabilitySession == null) {
			List<Book> bookList = this.listAll();
			while (bookList.size() > 1) {
				Book book = bookList.remove(0);
				for (Book bookInList : bookList) {
					BookListId bookListId = new BookListId(book.getId(), bookInList.getId());
					bookListProbability.add(bookListId);
				}
			}
		} else {
			bookListProbability = bookListProbabilitySession;
		}
		return bookListProbability;
	}
	
}
