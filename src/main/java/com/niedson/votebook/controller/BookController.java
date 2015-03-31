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
		
		System.out.println("voteBookHistId: " + request.getParameter("voteBookHistId"));
		System.out.println("selectedBookId: " + request.getParameter("selectedBookId"));
		System.out.println("request.getSession().getId(): " + request.getSession().getId());
		
		long voteBookHistId = request.getParameter("voteBookHistId") == null ? 0 : Long.valueOf(request.getParameter("voteBookHistId"));
		
		List<BookListId> bookListProbabilitySession = (List<BookListId>) request.getSession().getAttribute("bookListProbability");
		VoteBookHist voteBookHistSession = voteBookHistService.get(voteBookHistId);
		
		Book bookTeste = bookService.get((long) 2);
		List<VoteBookHist> listAll2 = voteBookHistService.listAll();
		VoteBookHist voteBookHist2 = voteBookHistService.get((long)1);
		
		if (!(voteBookHistSession == null)) {
			System.out.println(request.getParameter("selectedBookId") == null);
			System.out.println(request.getParameter("selectedBookId"));
			Book choosedBook = (request.getParameter("selectedBookId") == null) ? null : 
				bookService.get(Long.valueOf(request.getParameter("selectedBookId")));
			voteBookHistSession.setChoosedBook(choosedBook);
			voteBookHistSession.setDateHourVote(new Date());
			voteBookHistService.update(voteBookHistSession);
		}
		
		List<VoteBookHist> listAll = voteBookHistService.listAll();
		
		for (VoteBookHist voteBookHist : listAll) {
			System.out.println(voteBookHist.getId() + " | " + voteBookHist.getFirstBook() + " | " + voteBookHist.getSecondBook());
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
