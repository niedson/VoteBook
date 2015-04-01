package com.niedson.votebook.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.niedson.votebook.model.service.BookService;
import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.to.BookListId;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	
	@Mock
	BookService bookService;
	
	@Mock
	BookDAO bookDAO;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetNextBookPair() {
//		get
	}
	
//	public List<BookListId> getNextBookPair(List<BookListId> bookListProbabilitySession) {
//		List<BookListId> bookListProbability = new ArrayList<BookListId>();
//		if (bookListProbabilitySession == null) {
//			List<Book> bookList = this.listAll();
//			while (bookList.size() > 1) {
//				Book book = bookList.remove(0);
//				for (Book bookInList : bookList) {
//					BookListId bookListId = new BookListId(book.getId(), bookInList.getId());
//					bookListProbability.add(bookListId);
//				}
//			}
//		} else {
//			bookListProbability = bookListProbabilitySession;
//		}
//		return bookListProbability;
//	}	
	

	@Test
	public void testCreateListWithAllProbabilityVoting() {
		
		ReflectionTestUtils.setField(bookService, "bookDAO", bookDAO);
		
		Mockito.when(bookService.createListWithAllProbabilityVoting()).thenCallRealMethod();
		Mockito.when(bookService.listAll()).thenCallRealMethod();
		
		List<Book> listBook = new ArrayList<Book>();
		
		Book book = new Book();
		book.setName("A Torre Negra");
		book.setAuthor("Stephen King");
		book.setImage("TorreNegraOPistoleiro.jpg");
		listBook.add(book);

		book = new Book();
		book.setName("A dança da morte");
		book.setAuthor("Stephen King");
		book.setImage("ADancaDaMorte.jpg");
		listBook.add(book);
		
		book = new Book();
		book.setName("O Alquimista");
		book.setAuthor("Paulo Coelho");
		book.setImage("oAlquimista.jpg");
		listBook.add(book);
		int expected = listBook.size();

		Mockito.when(bookDAO.listAll()).thenReturn(listBook);
		
		List<BookListId> createListWithAllProbabilityVoting = bookService.createListWithAllProbabilityVoting();
		System.out.println("");
		
		assertEquals(expected, createListWithAllProbabilityVoting.size());

	}

}
