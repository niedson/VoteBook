package com.niedson.votebook.persistence.dao;

import java.util.List;

import com.niedson.votebook.to.RankingBookCount;

public interface RankingDAO {

//    public RankingUserBookCount getBookListCountByUser(User user);
    public List<RankingBookCount> listBookCount();
    
}
