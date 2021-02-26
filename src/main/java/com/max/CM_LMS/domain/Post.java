package com.max.CM_LMS.domain;

import java.time.LocalDate;

public class Post {

    private String text;
    private LocalDate datePost;

    public Post(String text, LocalDate datePost) {
        this.text = text;
        this.datePost = datePost;
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

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", datePost=" + datePost +
                '}';
    }
}
