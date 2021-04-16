package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Feed;

import java.sql.SQLException;
import java.util.List;

public interface FeedDao {
    List<Feed> getAll() throws Exception;

    Feed saveFeed(Feed feed) throws Exception;

    Feed getFeedById(int id) throws Exception;

    boolean updateFeed(Feed feed) throws Exception;

    boolean deleteFeedById(int id) throws Exception;
}
