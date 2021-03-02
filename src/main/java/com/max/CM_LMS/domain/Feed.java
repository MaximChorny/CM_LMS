package com.max.CM_LMS.domain;

import java.util.HashSet;
import java.util.Set;

public class Feed {
    Integer id;
    private Group group;
    private Set<Post> posts;

    public Feed(Group group) {
        this.group = group;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Group getGroup() {
        return group;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void addPost(Post post) {
        if (this.posts == null) {
            this.posts = new HashSet<>();
        }
        posts.add(post);
    }

    @Override
    public String toString() {
        return "Feed{" +
                "posts=" + posts +
                '}';
    }
}
