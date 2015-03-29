package com.niedson.votebook.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.entity.Book;

@WebListener
public class ListenerStartStopServer implements ServletContextListener{

	@Autowired
	private BookDAO bookDAO;
	
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		WebApplicationContextUtils

		.getRequiredWebApplicationContext(servletContextEvent.getServletContext())

		.getAutowireCapableBeanFactory()

		.autowireBean(this);

		if(bookDAO == null){
			System.out.println("DAO null");
		} else {
			System.out.println("DAO not null");
		}
		
		loadBookList();

	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
	
	private void loadBookList() {

		Book book = new Book();
		book.setName("A Torre Negra");
		book.setAuthor("Stephen King");
		book.setImage("/images/");
		
		bookDAO.save(book);

		book = new Book();
		book.setName("A dança da morte");
		book.setAuthor("Stephen King");
		book.setImage("/images/");
		
		bookDAO.save(book);
		book = new Book();
		book.setName("O Alquimista");
		book.setAuthor("Paulo Coelho");
		book.setImage("/images/");
		
		bookDAO.save(book);
		book = new Book();
		book.setName("Millenium");
		book.setAuthor("Stieg Larsson");
		book.setImage("/images/");
		
		bookDAO.save(book);
		book = new Book();
		book.setName("Senhor dos Aneis");
		book.setAuthor("J.R.R. Tolkien");
		book.setImage("/images/");
		
		bookDAO.save(book);
	}	

}
