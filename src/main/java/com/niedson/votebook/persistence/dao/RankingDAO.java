package com.niedson.votebook.persistence.dao;

import java.util.List;

import com.niedson.votebook.persistence.entity.User;
import com.niedson.votebook.to.RankingBookCount;
import com.niedson.votebook.to.RankingUserBookCount;

public interface RankingDAO {

    public RankingUserBookCount getBookListCountByUser(User user);
    public List<RankingBookCount> listBookCount();
    
}
