package com.niedson.votebook.model.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niedson.votebook.persistence.dao.RankingDAO;
import com.niedson.votebook.persistence.entity.User;
import com.niedson.votebook.to.RankingBookCount;
import com.niedson.votebook.to.RankingUserBookCount;

@Service
public class RankingService {
	
	
	private RankingDAO rankingDAO;
	
	@Autowired
	public RankingService(RankingDAO rankingDAO) {
		this.rankingDAO = rankingDAO;
	}
	
    public List<RankingBookCount> listBookCount(){
    	return rankingDAO.listBookCount();
    }
    
    public RankingUserBookCount getBookListCountByUser(User user){
    	return rankingDAO.getBookListCountByUser(user);
    }

	
}
