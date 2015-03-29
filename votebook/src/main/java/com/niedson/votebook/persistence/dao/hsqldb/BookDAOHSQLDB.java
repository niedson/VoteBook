package com.niedson.votebook.persistence.dao.hsqldb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.entity.Book;

@Repository
@Transactional
public class BookDAOHSQLDB implements BookDAO{

	@PersistenceContext
    private EntityManager em;

	public Book save(Book book) {
        em.persist(book);
        return book;
    }
     
    public List<Book> listAll() {
        return em.createQuery("FROM Book b", Book.class).getResultList();
    }
    
    public Book get(Long id) {
    	List<Book> resultList = em.createQuery(" FROM Book b WHERE b.id = " + id, Book.class).getResultList();
    	return resultList.isEmpty() ? null : resultList.get(0);
    }
    
	
}
