package com.max.CM_LMS.domain.dao.factory;

import com.max.CM_LMS.domain.dao.inDataBase.JdbcFeedDaoImpl;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryFeedDao;

public class FeedDaoFactory {
    public JdbcFeedDaoImpl getJdbcFeedDao() {
        return new JdbcFeedDaoImpl();
    }

    public inMemoryFeedDao getInMemoryFeedDao() {
        return new inMemoryFeedDao();
    }
}
