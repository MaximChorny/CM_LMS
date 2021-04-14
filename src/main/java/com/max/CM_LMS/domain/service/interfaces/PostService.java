package com.max.CM_LMS.domain.service.interfaces;

import com.max.CM_LMS.domain.Feed;
import com.max.CM_LMS.domain.Group;

public interface PostService {

    void addPost(Feed feed, String text);

    void addPost(Group group, String text);

}
