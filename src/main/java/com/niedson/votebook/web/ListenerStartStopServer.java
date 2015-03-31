package com.niedson.votebook.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.niedson.votebook.controller.BookController;
import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.entity.Book;

@WebListener
public class ListenerStartStopServer implements ServletContextListener{

	private Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookDAO bookDAO;
	
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		logger.info("Creating DB");

		WebApplicationContextUtils

		.getRequiredWebApplicationContext(servletContextEvent.getServletContext())

		.getAutowireCapableBeanFactory()

		.autowireBean(this);

		loadBookList();
		
		logger.info("Database created");

	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
	
	private void loadBookList() {
		
		logger.info("Loading table book");

		Book book = new Book();
		book.setName("A Torre Negra");
		book.setAuthor("Stephen King");
		book.setImage("TorreNegraOPistoleiro.jpg");
		
		bookDAO.save(book);

		book = new Book();
		book.setName("A dança da morte");
		book.setAuthor("Stephen King");
		book.setImage("ADancaDaMorte.jpg");
		
		bookDAO.save(book);
		book = new Book();
		book.setName("O Alquimista");
		book.setAuthor("Paulo Coelho");
		book.setImage("oAlquimista.jpg");
		
		bookDAO.save(book);
		book = new Book();
		book.setName("Millenium");
		book.setAuthor("Stieg Larsson");
		book.setImage("millenium.jpg");
		
		bookDAO.save(book);
		book = new Book();
		book.setName("Senhor dos Aneis");
		book.setAuthor("J.R.R. Tolkien");
		book.setImage("SenhorDosAneis.jpg");
		
		bookDAO.save(book);
		
		logger.info("Table book loaded");
	}	

}
