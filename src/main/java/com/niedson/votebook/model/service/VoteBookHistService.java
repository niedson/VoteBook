package com.niedson.votebook.model.service;

import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niedson.votebook.persistence.dao.VoteBookHistDAO;
import com.niedson.votebook.persistence.entity.VoteBookHist;

@Service
public class VoteBookHistService {
	
	private static final Logger logger = LoggerFactory.getLogger(VoteBookHistService.class);
	
	private VoteBookHistDAO voteBookHistDAO;
	
	@Autowired
	public VoteBookHistService(VoteBookHistDAO voteBookHistDAO) {
		this.voteBookHistDAO = voteBookHistDAO;
	}
	
	public VoteBookHist save(VoteBookHist voteBookHist){
		VoteBookHist savedVoteBookHist  = voteBookHistDAO.save(voteBookHist);
		return savedVoteBookHist;
	}
	
	public List<VoteBookHist> listAll(){
		return voteBookHistDAO.listAll();
	}
	
	public VoteBookHist get(Long id) {
		return voteBookHistDAO.get(id);
	}
	
	public VoteBookHist update(VoteBookHist voteBookHist){
		return voteBookHistDAO.update(voteBookHist);
	}
	
	 public List<VoteBookHist> findBySessionId(String sessionId){
		 return voteBookHistDAO.findBySessionId(sessionId); 
	 }
	 
}
