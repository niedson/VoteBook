package com.niedson.votebook.to;

import com.niedson.votebook.persistence.entity.Book;
import com.niedson.votebook.persistence.entity.User;

public class RankingUserBookCount extends RankingBookCount {

	public RankingUserBookCount(Book book, Long count, User user) {
		super(book, count);
		this.user = user;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
