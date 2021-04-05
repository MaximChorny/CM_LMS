package com.max.CM_LMS.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Feed {
    Integer id = 0;
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

    public void setGroup(Group group) {
        this.group = group;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return Objects.equals(id, feed.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
