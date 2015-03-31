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
import com.niedson.votebook.model.service.RankingService;
import com.niedson.votebook.to.RankingBookCount;

@Controller
@RequestMapping(value=ProjectURIConstants.RankingController.PREFIX_MAPPING)
public class RankingController {
	
	private Logger logger = LoggerFactory.getLogger(RankingController.class);
	 
	private RankingService rankingService;
	
	@Autowired 
	public RankingController(RankingService rankingService) {
		this.rankingService = rankingService;
	}
	
	@RequestMapping(value=ProjectURIConstants.RankingController.SHOW)
	public ModelAndView send(HttpServletRequest request){
		
		List<RankingBookCount> listBookCount = rankingService.listBookCount();
		
		return new ModelAndView("/ranking/show", "listBookCount", listBookCount);
	}
	
	
	
}
