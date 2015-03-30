package com.niedson.votebook.persistence.dao;

import java.util.List;

import com.niedson.votebook.persistence.entity.VoteBookHist;

public interface VoteBookHistDAO {
	
	public VoteBookHist save(VoteBookHist voteBookHist);
    public List<VoteBookHist> listAll();
    public VoteBookHist get(Long id);
    public VoteBookHist update(VoteBookHist voteBookHist);
    public List<VoteBookHist> findBySessionId(String sessionId);
    
}
