package com.max.CM_LMS.domain.dao.factory;

import com.max.CM_LMS.domain.dao.FeedDao;
import com.max.CM_LMS.domain.dao.GroupDao;
import com.max.CM_LMS.domain.dao.LessonDao;

public class DaoAbstractFactory {
    public static final String In_Memory = "InMemory";
    public static final String JDBC = "jdbc";
    private final GroupDaoFactory groupDaoFactory;
    private final LessonDaoFactory lessonDaoFactory;
    private final FeedDaoFactory feedDaoFactory;

    public DaoAbstractFactory(LessonDaoFactory lessonDaoFactory, FeedDaoFactory feedDaoFactory) {
        this.feedDaoFactory = new FeedDaoFactory();
        this.lessonDaoFactory = new LessonDaoFactory();
        this.groupDaoFactory = new GroupDaoFactory();
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

/*
 if(In_Memory.equalsIgnoreCase(type)){
            return
        }
        if(JDBC.equalsIgnoreCase(type)){
            return
        }
        return null;
* */
}
