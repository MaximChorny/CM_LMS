package com.max.CM_LMS.domain.dao.factory;

import com.max.CM_LMS.domain.dao.*;

public class DaoAbstractFactory {
    public static final String In_Memory = "InMemory";
    public static final String JDBC = "jdbc";
    private final GroupDaoFactory groupDaoFactory;
    private final LessonDaoFactory lessonDaoFactory;
    private final FeedDaoFactory feedDaoFactory;
    private final UserDaoFactory userDaoFactory;
    private final PostDaoFactory postDaoFactory;
    private final HomeTaskDaoFactory homeTaskDaoFactory;
    private final  HomeWorkDaoFactory homeWorkDaoFactory;

    public DaoAbstractFactory() {
        this.feedDaoFactory = new FeedDaoFactory();
        this.lessonDaoFactory = new LessonDaoFactory();
        this.groupDaoFactory = new GroupDaoFactory();
        this.userDaoFactory = new UserDaoFactory();
        this.postDaoFactory = new PostDaoFactory();
        this.homeTaskDaoFactory = new HomeTaskDaoFactory();
        this.homeWorkDaoFactory = new HomeWorkDaoFactory();
    }

    public GroupDao createGroupDao(String type) {
        if (In_Memory.equalsIgnoreCase(type)) {
            return groupDaoFactory.getInMemoryGroupDao();
        }
        if (JDBC.equalsIgnoreCase(type)) {
            return groupDaoFactory.getJdbcGroupDao();
        }
        return null;
    }

    public LessonDao createLessonDao(String type) {
        if (In_Memory.equalsIgnoreCase(type)) {
            return lessonDaoFactory.getInMemoryLessonDao();
        }
        if (JDBC.equalsIgnoreCase(type)) {
            return lessonDaoFactory.getJdbcLessonDao();
        }
        return null;
    }

    public FeedDao createFeedDao(String type) {
        if (In_Memory.equalsIgnoreCase(type)) {
            return feedDaoFactory.getInMemoryFeedDao();
        }
        if (JDBC.equalsIgnoreCase(type)) {
            return feedDaoFactory.getJdbcFeedDao();
        }
        return null;
    }

    public UserDao createUserDao(String type) {
        if (In_Memory.equalsIgnoreCase(type)) {
            return userDaoFactory.getInMemoryUserDao();
        }
        if (JDBC.equalsIgnoreCase(type)) {
            return userDaoFactory.getJdbcUserDao();
        }
        return null;
    }

    public PostDao createPostDao(String type){
        if(In_Memory.equalsIgnoreCase(type)){
            return postDaoFactory.getInMemoryPostDao();
        }
        if(JDBC.equalsIgnoreCase(type)){
            return postDaoFactory.getJdbcPostDao();
        }
        return null;
    }

    public HomeTaskDao createHomeTask(String type){
        if(In_Memory.equalsIgnoreCase(type)){
            return homeTaskDaoFactory.getInMemoryHomeTaskDao();
        }
        if(JDBC.equalsIgnoreCase(type)){
            return homeTaskDaoFactory.getJdbcHomeTaskDao();
        }
        return null;
    }

    public HomeWorkDao createHomeWork(String type){
        if(In_Memory.equalsIgnoreCase(type)){
            return homeWorkDaoFactory.getInMemoryHomeWorkDao();
        }
        if(JDBC.equalsIgnoreCase(type)){
            return homeWorkDaoFactory.getJdbcHomeWorkDao();
        }
        return null;

    }

}
