package com.niedson.votebook.to;

import com.niedson.votebook.persistence.entity.Book;

public class RankingBookCount {
	private Book book;
	private Long count;
	
	public RankingBookCount() {}
	
	public RankingBookCount(Book book, Long count) {
		super();
		this.book = book;
		this.count = count;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
