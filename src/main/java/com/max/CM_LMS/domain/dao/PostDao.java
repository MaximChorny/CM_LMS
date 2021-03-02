package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Post;

import java.util.List;

public interface PostDao {
    List<Post> getAll();

    Post savePostTask(Post post);

    Post getPostById(int id);

    boolean updatePost(Post post);

    boolean deletePostById(int id);
}
