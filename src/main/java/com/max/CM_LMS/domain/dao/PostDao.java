package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostDao {
    List<Post> getAll() throws Exception;

    Post savePost(Post post) throws SQLException, Exception;

    Post getPostById(int id) throws Exception;

    boolean updatePost(Post post) throws Exception;

    boolean deletePostById(int id) throws Exception;
}
