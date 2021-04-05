package com.max.CM_LMS.domain.dao.inMemory;

import com.max.CM_LMS.domain.Post;
import com.max.CM_LMS.domain.dao.PostDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class inMemoryPostDao implements PostDao {

    @Override
    public List<Post> getAll() {
        return new ArrayList<>(Persistence.getPosts().values());
    }

    @Override
    public Post savePost(Post post) {
        int newId = Persistence.getNewId(Persistence.getPosts());
        post.setId(newId);
        Persistence.getPosts().put(newId, post);
        return post;
    }

    @Override
    public Post getPostById(int id) {
        if (Persistence.getPosts().containsKey(id)) {
            return Persistence.getPosts().get(id);
        }
       return null;
    }

    @Override
    public boolean updatePost(Post post) {
        int id = post.getId();
        Map<Integer, Post> posts = Persistence.getPosts();
        if (posts.containsKey(id)) {
            posts.put(id, post);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePostById(int id) {
        Map<Integer, Post> posts = Persistence.getPosts();
        if (posts.containsKey(id)) {
            posts.remove(id);
            return true;
        }
        return false;
    }
}
