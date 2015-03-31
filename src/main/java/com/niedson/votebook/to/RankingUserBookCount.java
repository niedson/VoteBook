package com.niedson.votebook.to;

import java.util.List; 

import com.niedson.votebook.persistence.entity.User;

public class RankingUserBookCount {
	private User user;
	private List<RankingBookCount> listRankingBookCount;

	public RankingUserBookCount() {}
	
	public RankingUserBookCount(User user,
			List<RankingBookCount> listRankingBookCount) {
		this.user = user;
		this.listRankingBookCount = listRankingBookCount;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<RankingBookCount> getListRankingBookCount() {
		return listRankingBookCount;
	}
	public void setListRankingBookCount(List<RankingBookCount> listRankingBookCount) {
		this.listRankingBookCount = listRankingBookCount;
	}
}
