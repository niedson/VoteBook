package com.niedson.votebook.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class VoteBookHist {
	
	@Id @GeneratedValue
	private Long id;
	
	private Long book1;
	private Long book2;
	private Long choosedBook;
	private Date dateHourVote;
	private String sessionId;
	
	
	public VoteBookHist(Long book1, Long book2, Long choosedBook,
			Date dateHourVote, String sessionId) {
		super();
		this.book1 = book1;
		this.book2 = book2;
		this.choosedBook = choosedBook;
		this.dateHourVote = dateHourVote;
		this.sessionId = sessionId;
	}
	
	public VoteBookHist() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateHourVote() {
		return dateHourVote;
	}
	public void setDateHourVote(Date dateHourVote) {
		this.dateHourVote = dateHourVote;
	}
	public Long getBook1() {
		return book1;
	}
	public void setBook1(Long book1) {
		this.book1 = book1;
	}
	public Long getBook2() {
		return book2;
	}
	public void setBook2(Long book2) {
		this.book2 = book2;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Long getChoosedBook() {
		return choosedBook;
	}
	public void setChoosedBook(Long choosedBook) {
		this.choosedBook = choosedBook;
	}
}
