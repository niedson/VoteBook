package com.niedson.votebook.to;

import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.persistence.entity.User;

public class RankingUserBookCount extends RankingBookCount {
	private User user;

	public RankingUserBookCount() {
		super();
	}
	
	public RankingUserBookCount(Book book, Long count, User user) {
		super(book, count);
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
