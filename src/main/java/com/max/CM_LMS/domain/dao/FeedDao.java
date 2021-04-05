package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Feed;

import java.sql.SQLException;
import java.util.List;

public interface FeedDao {
    List<Feed> getAll() throws SQLException;

    Feed saveFeed(Feed feed) throws SQLException;

    Feed getFeedById(int id) throws SQLException;

    boolean updateFeed(Feed feed) throws SQLException;

    boolean deleteFeedById(int id) throws SQLException;
}
