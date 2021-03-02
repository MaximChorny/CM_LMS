package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Feed;

import java.util.List;

public interface FeedDao {
    List<Feed> getAll();

    Feed saveFeed(Feed group);

    Feed getFeedById(int id);

    boolean updateFeed(Feed group);

    boolean deleteFeedById(int id);
}
