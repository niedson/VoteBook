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

	public Long save(Book book) {
        em.persist(book);
        return book.getId();
    }
     
    public List<Book> listAll() {
        return em.createQuery("FROM Book b", Book.class).getResultList();
    }
	
}
