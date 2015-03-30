package com.niedson.votebook.persistence.dao.hsqldb;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niedson.votebook.persistence.dao.VoteBookHistDAO;
import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.persistence.entity.VoteBookHist;

@Repository
@Transactional
public class VoteBookHistDAOHSQLDB implements VoteBookHistDAO{

	@PersistenceContext
    private EntityManager em;

	public VoteBookHist save(VoteBookHist voteBookHist) {
        em.persist(voteBookHist);
        return voteBookHist;
    }
     
	
	public VoteBookHist update(VoteBookHist voteBookHist) {
		
		VoteBookHist voteBookHistEm = em.find(VoteBookHist.class, voteBookHist.getId());
		
		em.getTransaction().begin();
		voteBookHistEm.setBook1(voteBookHist.getBook1());
		voteBookHistEm.setBook2(voteBookHist.getBook2());
		voteBookHistEm.setChoosedBook(voteBookHist.getChoosedBook());
		voteBookHistEm.setDateHourVote(voteBookHist.getDateHourVote());
		voteBookHistEm.setSessionId(voteBookHist.getSessionId());
		em.getTransaction().commit();
		
		return voteBookHistEm;
	}
	
    public List<VoteBookHist> listAll() {
        return em.createQuery("FROM VoteBookHist vbh", VoteBookHist.class).getResultList();
    }
    
    public VoteBookHist get(Long id) {
    	List<VoteBookHist> resultList = em.createQuery(" FROM VoteBookHist vbh WHERE vbh.id = " + id, VoteBookHist.class).getResultList();
    	return resultList.isEmpty() ? null : resultList.get(0);
    }
	
}
