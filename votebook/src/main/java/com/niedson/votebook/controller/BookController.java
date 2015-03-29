package com.niedson.votebook.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.runner.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niedson.votebook.controller.uri.ProjectURIConstants;
import com.niedson.votebook.model.service.BookService;
import com.niedson.votebook.persistence.entity.Book;

@Controller
@RequestMapping(value=ProjectURIConstants.BookController.PREFIX_MAPPING)
public class BookController {
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);
	 
	private BookService bookService;
	
	@Autowired 
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value=ProjectURIConstants.BookController.CHOOSE_BOOK)
	public ModelAndView voteNoLivro(){
		
		Random gerador = new Random();
		
		List<Book> bookList = bookService.listAll();
		int id = gerador.nextInt( bookList.size());
		Book book1 = bookList.remove(id);
		
		id = gerador.nextInt( bookList.size());
		Book book2 = bookList.remove(id);
		
		List<Book> selectedBooks = new ArrayList<Book>();
		selectedBooks.add(book1);
		selectedBooks.add(book2);
		
				
		return new ModelAndView("book/choose", "bookList", selectedBooks);
	}
	
	
	
}
