package com.niedson.votebook.persistence.dao.hsqldb;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.dao.RankingDAO;
import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.persistence.entity.User;
import com.niedson.votebook.persistence.entity.VoteBookHist;
import com.niedson.votebook.to.RankingBookCount;
import com.niedson.votebook.to.RankingUserBookCount;

@Repository
@Transactional
public class RankingDAOHSQLDB implements RankingDAO{

	@PersistenceContext
    private EntityManager em;
	
	private BookDAO bookDAO;
	
	@Autowired
	public RankingDAOHSQLDB(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public List<RankingBookCount> listBookCount() {
		
		Query query = em.createNativeQuery("SELECT choosedBook, count(id) as cn FROM VOTEBOOKHIST WHERE choosedBook is not null GROUP BY choosedBook" );
		List<Object[]> resultList = query.getResultList();
		
		List<RankingBookCount> listBookCount = new ArrayList<RankingBookCount>(); 
		
		for (Object[] bookCount : resultList) {
			RankingBookCount rankingBookCount = new RankingBookCount(bookDAO.get(Long.valueOf(String.valueOf(bookCount[0]))),
					Long.valueOf(String.valueOf(bookCount[1])));
			listBookCount.add(rankingBookCount);
		}
		
    	return listBookCount;
	}

//    public Book get(Long id) {
//    	List<Book> resultList = em.createQuery(" FROM Book b WHERE b.id = " + id, Book.class).getResultList();
//    	return resultList.isEmpty() ? null : resultList.get(0);
//    }
	
}
