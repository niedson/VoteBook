package com.niedson.votebook.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niedson.votebook.controller.uri.ProjectURIConstants;
import com.niedson.votebook.model.service.RankingService;
import com.niedson.votebook.model.service.UserService;
import com.niedson.votebook.persistence.entity.User;
import com.niedson.votebook.to.RankingBookCount;
import com.niedson.votebook.to.RankingUserBookCount;

@Controller
@RequestMapping(value=ProjectURIConstants.RankingController.PREFIX_MAPPING)
public class RankingController {
	
	private Logger logger = LoggerFactory.getLogger(RankingController.class);
	 
	private RankingService rankingService;
	private UserService userService;
	
	@Autowired 
	public RankingController(RankingService rankingService, UserService userService) {
		this.rankingService = rankingService;
		this.userService = userService;
	}
	
	@RequestMapping(value=ProjectURIConstants.RankingController.SHOW)
	public String send(HttpServletRequest request, Model model){
		
		System.out.println(request.getParameter("userId"));
		
		List<RankingBookCount> listBookCount = rankingService.listBookCount();
		
		User user = userService.get(Long.valueOf(request.getParameter("userId")));
		RankingUserBookCount userBookCount = rankingService.getBookListCountByUser(user);
		
		model.addAttribute("listBookCount", listBookCount);
		model.addAttribute("userBookCount", userBookCount);
		
		return "/ranking/show";
	}
	
}
