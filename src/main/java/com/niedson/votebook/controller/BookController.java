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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value={ProjectURIConstants.BookController.CHOOSE_BOOK, "/"})
	public ModelAndView voteBook(HttpServletRequest request){
		List<BookListId> bookListProbability = (List<BookListId>) request.getSession().getAttribute("bookListProbability"); 
		
		boolean isFirstVote = (bookListProbability == null);
		if(isFirstVote){
			bookListProbability = bookService.createListWithAllProbabilityVoting();
			request.getSession().setAttribute("bookListProbability", bookListProbability);
		}
		
		boolean userCurrentVoting = (request.getParameter("voteBookHistId") == null);
		String selectedBookIdString = request.getParameter("selectedBookId");
		if(userCurrentVoting == false && selectedBookIdString != null){
			Long voteBookHistId = Long.parseLong(request.getParameter("voteBookHistId"));
			long selectedBookId = Long.parseLong(selectedBookIdString);
			VoteBookHist voteBookHist = voteBookHistService.get(voteBookHistId);
			
			String currentSessionId = request.getSession().getId();
			boolean isValidVoteForCurrentSession = voteBookHist.getSessionId() == currentSessionId 
													&& (voteBookHist.getFirstBook().getId() == selectedBookId 
														|| voteBookHist.getSecondBook().getId() == selectedBookId);
			if(isValidVoteForCurrentSession){
				voteBookHistService.updateVoteBookSetSelectedBook(voteBookHist, selectedBookId);
			} else {
				BookListId returnBookListVoteAgain = (BookListId) request.getSession().getAttribute("currentVoteBook");
				request.getSession().setAttribute("errorMessage", "O seu voto não é válido por motivos de segurança. Por favor, vote novamente.");
			}
		}
		
		
		boolean isVotingInAllProbabilitys = bookListProbability.isEmpty();
		if (isVotingInAllProbabilitys) {
			request.getSession().removeAttribute("bookListProbability");
			return new ModelAndView("redirect:/user/register", "", null);
		}
		
		
		return getTwoBooksForVoting(request, bookListProbability);
	}

	private ModelAndView getTwoBooksForVoting(HttpServletRequest request, List<BookListId> bookListProbability) {
		int index = new Random().nextInt( bookListProbability.size() );
		BookListId bookListProbabilityChosed = bookListProbability.remove(index);
		request.getSession().setAttribute("currentVoteBook", bookListProbabilityChosed);
		
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
