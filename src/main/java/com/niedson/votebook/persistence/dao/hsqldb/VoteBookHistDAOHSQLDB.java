package com.niedson.votebook.persistence.dao.hsqldb;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niedson.votebook.persistence.dao.VoteBookHistDAO;
import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.persistence.entity.User;
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
		em.merge(voteBookHist);
		
		return voteBookHistEm;
	}
	
    public List<VoteBookHist> listAll() {
        return em.createQuery("FROM VoteBookHist vbh", VoteBookHist.class).getResultList();
    }
    
    public VoteBookHist get(Long id) {
    	try{
	    	VoteBookHist result = em.createQuery(" FROM VoteBookHist vbh WHERE vbh.id = " + id, VoteBookHist.class).getSingleResult();
	    	return result;
        } catch(NoResultException e) {
            return null;
        }
    	
    }
    
    public List<VoteBookHist> findBySessionId(String sessionId) {
    	try{
    		List<VoteBookHist> result = em.createQuery(" FROM VoteBookHist vbh WHERE vbh.sessionId = '" + sessionId + "' AND user_id is null", 
    				VoteBookHist.class).getResultList();
    		return result;
    	} catch(NoResultException e) {
    		return null;
    	}
    }
	
    public VoteBookHist findByUser(User user) {
    	try{
    		VoteBookHist result = em.createQuery(" FROM VoteBookHist vbh WHERE vbh.user_id = " + user.getId(), 
    				VoteBookHist.class).getSingleResult();
    		return result;
    	} catch(NoResultException e) {
    		return null;
    	}
    }
    
}
