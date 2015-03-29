package com.niedson.votebook.persistence.entity;

import java.util.Date;

public class VoteBookHist {
	
	private Long id;
	private Book book1;
	private Book book2;
	private Book choosedBook;
	private Date dateHourVote;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Book getBook1() {
		return book1;
	}
	public void setBook1(Book book1) {
		this.book1 = book1;
	}
	public Book getBook2() {
		return book2;
	}
	public void setBook2(Book book2) {
		this.book2 = book2;
	}
	public Date getDateHourVote() {
		return dateHourVote;
	}
	public void setDateHourVote(Date dateHourVote) {
		this.dateHourVote = dateHourVote;
	}
	public Book getChoosedBook() {
		return choosedBook;
	}
	public void setChoosedBook(Book choosedBook) {
		this.choosedBook = choosedBook;
	}
	

}
