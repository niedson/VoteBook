package com.niedson.votebook.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
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
import com.niedson.votebook.model.service.VoteBookHistService;
import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.persistence.entity.VoteBookHist;
import com.niedson.votebook.to.BookListId;

@Controller
@RequestMapping(value=ProjectURIConstants.BookController.PREFIX_MAPPING)
public class BookController {
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);
	 
	private BookService bookService;
	private VoteBookHistService voteBookHistService;
	
	@Autowired 
	public BookController(BookService bookService, VoteBookHistService voteBookHistService) {
		this.bookService = bookService;
		this.voteBookHistService = voteBookHistService;
	}
	
	@RequestMapping(value=ProjectURIConstants.BookController.CHOOSE_BOOK)
	public ModelAndView voteNoLivro(HttpServletRequest request){
		
		Random gerador = new Random();
		
		System.out.println("voteBookHistId" + request.getParameter("voteBookHistId"));
		System.out.println("selectedBookId" + request.getParameter("selectedBookId"));
		
		List<BookListId> bookListProbabilitySession = (List<BookListId>) request.getSession().getAttribute("bookListProbability");
		VoteBookHist voteBookHistSession = voteBookHistService.get((Long) request.getSession().getAttribute("voteBookHistId"));
		
		if (!(voteBookHistSession == null)) {
			voteBookHistSession.setChoosedBook(Long.getLong(request.getParameter("selectedBookId")));
			voteBookHistSession.setDateHourVote(new Date());
			voteBookHistService.update(voteBookHistSession);
		}
		
		List<VoteBookHist> listAll = voteBookHistService.listAll();
		
		for (VoteBookHist voteBookHist : listAll) {
			System.out.println(voteBookHist.getId() + " | " + voteBookHist.getBook1() + " | " + voteBookHist.getBook2());
		}
		
		List<BookListId> bookListProbability = new ArrayList<BookListId>();
		
		if (bookListProbabilitySession == null) {
			List<Book> bookList = bookService.listAll();
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
		
		if (bookListProbability.size() == 0) {
			request.getSession().removeAttribute("bookListProbability");
			
			return new ModelAndView("redirect:/user/register", "asdsads", null);
		} else {
			
			int index = gerador.nextInt( bookListProbability.size());
			BookListId  bookListProbabilityChosed = bookListProbability.remove(index);
			
			List<Book> selectedBooks = new ArrayList<Book>();
			Long firstBookId = bookListProbabilityChosed.getFirstBookId();
			Long secondBookId = bookListProbabilityChosed.getSecondBookId();

			selectedBooks.add(bookService.get(firstBookId));
			selectedBooks.add(bookService.get(secondBookId));
			
			VoteBookHist voteBookHist = voteBookHistService.save(new VoteBookHist(firstBookId, secondBookId, 
					null, new Date(), null));
			
			request.getSession().setAttribute("bookListProbability", bookListProbability);
			request.getSession().setAttribute("voteBookHist", voteBookHist);
			
			return new ModelAndView("book/choose", "bookList", selectedBooks);
		}
	}
	
	
	
}
