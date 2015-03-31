package com.niedson.votebook.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niedson.votebook.controller.uri.ProjectURIConstants;
import com.niedson.votebook.model.service.UserService;
import com.niedson.votebook.model.service.VoteBookHistService;
import com.niedson.votebook.persistence.entity.User;
import com.niedson.votebook.persistence.entity.VoteBookHist;

@Controller
@RequestMapping(value=ProjectURIConstants.UserController.PREFIX_MAPPING)
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	private UserService userService;
	private VoteBookHistService voteBookHistService;
	
	@Autowired 
	public UserController(UserService userService, VoteBookHistService voteBookHistService) {
		this.userService = userService;
		this.voteBookHistService = voteBookHistService;
	}
	
	@RequestMapping(value=ProjectURIConstants.UserController.REGISTER)
	public ModelAndView register(HttpServletRequest request){
		return new ModelAndView("/user/register", "bookList", null);
	}
	
	@RequestMapping(value=ProjectURIConstants.UserController.SAVE)
	public ModelAndView send(HttpServletRequest request){
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user = userService.findUserByNameAndEmailOrCreate(name, email);
		
		String sessionId = request.getSession().getId();
		
		List<VoteBookHist> listVoteBookHist = voteBookHistService.findBySessionId(sessionId);
			
		for (VoteBookHist savedBookHist : listVoteBookHist) {
			savedBookHist.setUser(user);
			voteBookHistService.update(savedBookHist);
		}
		
		return new ModelAndView("redirect:/ranking/show?userId=" + user.getId());
	}

	
}
