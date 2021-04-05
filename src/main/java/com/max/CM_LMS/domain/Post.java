package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private Integer id = 0;
    private String text;
    private LocalDate datePost;
    private Feed feed;
    User author;

    public Post(String text, LocalDate datePost) {
        this.text = text;
        this.datePost = datePost;
    }

    public Post(String text, LocalDate datePost,User author) {
        this.text = text;
        this.datePost = datePost;
        this.author = author;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDatePost() {
        return datePost;
    }

    public void setDatePost(LocalDate datePost) {
        this.datePost = datePost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", datePost=" + datePost +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(text, post.text) && Objects.equals(datePost, post.datePost) && Objects.equals(feed, post.feed) && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, datePost, feed, author);
    }
}
