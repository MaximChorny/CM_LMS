package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.Feed;
import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.service.interfaces.FeedService;

public class FeedServiceIm implements FeedService {

    @Override
    public boolean createFeedInGroup(Group group) {
       if(group.getFeed() == null)
       {
           group.setFeed(new Feed(group));
           return true;
       }
        return false;
    }

}
