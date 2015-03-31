package com.niedson.votebook.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

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
import com.niedson.votebook.persistence.entity.User;
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
	
	@RequestMapping(value={ProjectURIConstants.BookController.CHOOSE_BOOK, "/"})
	public ModelAndView voteBook(HttpServletRequest request){
		
		Random gerador = new Random();
		
		long voteBookHistId = request.getParameter("voteBookHistId") == null ? 0 : Long.valueOf(request.getParameter("voteBookHistId"));
		
		List<BookListId> bookListProbabilitySession = (List<BookListId>) request.getSession().getAttribute("bookListProbability");
		VoteBookHist voteBookHistSession = voteBookHistService.get(voteBookHistId);
		String selectedBookId = request.getParameter("selectedBookId");
		
		voteBookHistService.updateVoteBookSetSelectedBook(voteBookHistSession, selectedBookId);
		
		List<BookListId> bookListProbability  = bookService.getNextBookPair(bookListProbabilitySession);
		
		if (bookListProbability.size() == 0) {
			request.getSession().removeAttribute("bookListProbability");
			return new ModelAndView("redirect:/user/register", "", null);
		} else {
			
			int index = gerador.nextInt( bookListProbability.size());
			BookListId  bookListProbabilityChosed = bookListProbability.remove(index);
			
			List<Book> selectedBooks = new ArrayList<Book>();
			Book firstBookId = bookService.get(bookListProbabilityChosed.getFirstBookId());
			Book secondBookId = bookService.get(bookListProbabilityChosed.getSecondBookId());

			selectedBooks.add(bookService.get(firstBookId.getId()));
			selectedBooks.add(bookService.get(secondBookId.getId()));
			
			VoteBookHist voteBookHist = voteBookHistService.save(new VoteBookHist(firstBookId, secondBookId, 
					null, new Date(), request.getSession().getId(), null));
			
			request.getSession().setAttribute("bookListProbability", bookListProbability);
			request.getSession().setAttribute("voteBookHist", voteBookHist);
			
			return new ModelAndView("book/choose", "bookList", selectedBooks);
		}
	}


	
}
