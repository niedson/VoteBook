package com.niedson.votebook.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

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
import com.niedson.votebook.to.BookListId;

@Controller
@RequestMapping(value=ProjectURIConstants.UserController.PREFIX_MAPPING)
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	private BookService bookService;
	
	@Autowired 
	public UserController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value=ProjectURIConstants.UserController.REGISTER)
	public ModelAndView voteNoLivro(HttpServletRequest request){
		return new ModelAndView("/user/register", "bookList", null);
	}
	
	
	
}