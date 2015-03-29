package com.niedson.votebook.model.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niedson.votebook.model.service.BookService;
import com.niedson.votebook.persistence.dao.BookDAO;


public class SpringApplicationContext {
	
	private static final ConfigurableApplicationContext context;
	public static final Service SERVICE;
	public static final Dao DAO;
	
	static {
		context = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");
		SpringApplicationContext springApplicationContext = new SpringApplicationContext();
		SERVICE = springApplicationContext.new Service();
		DAO = springApplicationContext.new Dao();
	}
	public static void closeApplicationContext(){
		context.close();
	}
	
	public class Service{
		private Service(){}
		
		public BookService getDeliveryService(){
			return context.getBean("deliveryService", BookService.class);
		}
	}
	
	public class Dao{
		private Dao(){}
		
		public BookDAO getBookDAO(){
			return context.getBean("bookDAOHSQLDB", BookDAO.class);
		}
	}
	

}
