package com.max.CM_LMS.domain.persistence;

import com.max.CM_LMS.domain.*;

import java.util.HashMap;
import java.util.Map;

public class Persistence {

    private static Map<Integer, Group> groupMap = new HashMap<>();
    private static Map<Integer, Feed> feedMap = new HashMap<>();
    private static Map<Integer, HomeTask> homeTaskMap = new HashMap<>();
    private static Map<Integer, Lesson> lessonMap = new HashMap<>();
    private static Map<Integer, Post> postMap = new HashMap<>();
    private static Map<Integer, User> userMapMap = new HashMap<>();
    private static Map<Integer, HomeWork> homeWorkMap = new HashMap<>();

    public static Map<Integer, HomeWork> getHomeWorkMap() {
        return homeWorkMap;
    }

    public static Map<Integer, User> getUsers() {
        return userMapMap;
    }

    public static Map<Integer, Post> getPosts() {
        return postMap;
    }

    public static Map<Integer, Lesson> getLessons() {
        return lessonMap;
    }

    public static Map<Integer, HomeTask> getHomeworkTasks() {
        return homeTaskMap;
    }

    public static  Map<Integer, Feed> getFeeds(){
        return feedMap;
    }

    public static Map<Integer, Group> getGroups() {
        return groupMap;
    }

    public static <T> int getNewId(Map<Integer, T> storage) {
        int max = 0;
        for (Integer currentId : storage.keySet()) {
            if (currentId > max) {
                max = currentId;
            }
        }
        return ++max;
    }

    public static<T> void printAll(Map<Integer,T> storage) {
        System.out.println(storage.toString());
    }
}
