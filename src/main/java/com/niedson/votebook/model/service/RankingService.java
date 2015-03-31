package com.niedson.votebook.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niedson.votebook.persistence.dao.RankingDAO;
import com.niedson.votebook.to.RankingBookCount;

@Service
public class RankingService {
	
	private static final Logger logger = LoggerFactory.getLogger(RankingService.class);
	
	private RankingDAO rankingDAO;
	
	@Autowired
	public RankingService(RankingDAO rankingDAO) {
		this.rankingDAO = rankingDAO;
	}
	
    public List<RankingBookCount> listBookCount(){
    	return rankingDAO.listBookCount();
    }

	
}
