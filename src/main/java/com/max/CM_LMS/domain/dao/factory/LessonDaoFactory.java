package com.max.CM_LMS.domain.dao.factory;

import com.max.CM_LMS.domain.dao.inDataBase.JdbcLessonDaoImpl;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryLessonDao;

public class LessonDaoFactory {
    public JdbcLessonDaoImpl getJdbcLessonDao() {
        return new JdbcLessonDaoImpl();
    }

    public inMemoryLessonDao getInMemoryLessonDao(){
        return new inMemoryLessonDao();
    }

}
