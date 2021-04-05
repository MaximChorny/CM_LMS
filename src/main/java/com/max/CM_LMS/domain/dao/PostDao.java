package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostDao {
    List<Post> getAll() throws SQLException;

    Post savePost(Post post) throws SQLException;

    Post getPostById(int id) throws SQLException;

    boolean updatePost(Post post) throws SQLException;

    boolean deletePostById(int id) throws SQLException;
}
