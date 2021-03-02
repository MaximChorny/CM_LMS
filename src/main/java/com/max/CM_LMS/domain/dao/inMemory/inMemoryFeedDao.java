package com.max.CM_LMS.domain.dao.inMemory;

import com.max.CM_LMS.domain.Feed;
import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.dao.FeedDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class inMemoryFeedDao implements FeedDao {

    @Override
    public List<Feed> getAll() {
        return new ArrayList<>(Persistence.getFeeds().values());
    }

    @Override
    public Feed saveFeed(Feed feed) {
        int newId = Persistence.getNewId(Persistence.getFeeds());
        feed.setId(newId);
        Persistence.getFeeds().put(newId, feed);
        return feed;
    }

    @Override
    public Feed getFeedById(int id) {
        if (Persistence.getFeeds().containsKey(id)) {
            return Persistence.getFeeds().get(id);
        }
        return new Feed(new Group("Error", "Err", LocalDate.MIN));
    }

    @Override
    public boolean updateFeed(Feed feed) {
        int id = feed.getId();
        Map<Integer, Feed> feeds = Persistence.getFeeds();
        if (feeds.containsKey(id)) {
            feeds.put(id, feed);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFeedById(int id) {
        Map<Integer, Feed> feeds = Persistence.getFeeds();
        if (feeds.containsKey(id)) {
            feeds.remove(id);
            return true;
        }
        return false;
    }

}
