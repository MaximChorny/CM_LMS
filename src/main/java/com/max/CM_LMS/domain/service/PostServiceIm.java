package com.max.CM_LMS.domain.service;

import com.max.CM_LMS.domain.Feed;
import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Post;
import com.max.CM_LMS.domain.service.interfaces.PostService;

import java.time.LocalDate;

public class PostServiceIm implements PostService {
    @Override
    public void addPost(Feed feed, String text) {
        feed.addPost(new Post(text, LocalDate.now()));
    }

    @Override
    public void addPost(Group group, String text) {
     group.getFeed().addPost(new Post(text, LocalDate.now()));
    }

}
