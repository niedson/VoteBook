package com.niedson.votebook.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class VoteBookHist {
	
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne
	private Book firstBook;

	@OneToOne
	private Book secondBook;
	
	@OneToOne
	private Book choosedBook;
	private Date dateHourVote;
	private String sessionId;
	
	@ManyToOne
	private User user;

	public VoteBookHist() {}
	
	public VoteBookHist(Book firstBook, Book secondBook, Book choosedBook,
			Date dateHourVote, String sessionId, User user) {
		super();
		this.firstBook = firstBook;
		this.secondBook = secondBook;
		this.choosedBook = choosedBook;
		this.dateHourVote = dateHourVote;
		this.sessionId = sessionId;
		this.user = user;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Book getFirstBook() {
		return firstBook;
	}
	public void setFirstBook(Book firstBook) {
		this.firstBook = firstBook;
	}
	public Book getSecondBook() {
		return secondBook;
	}
	public void setSecondBook(Book secondBook) {
		this.secondBook = secondBook;
	}
	public Book getChoosedBook() {
		return choosedBook;
	}
	public void setChoosedBook(Book choosedBook) {
		this.choosedBook = choosedBook;
	}
	public Date getDateHourVote() {
		return dateHourVote;
	}
	public void setDateHourVote(Date dateHourVote) {
		this.dateHourVote = dateHourVote;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
