package com.max.CM_LMS.domain.dao.factory;

import com.max.CM_LMS.domain.dao.inDataBase.JdbcHomeTaskImpl;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryHomeTaskDao;

public class HomeTaskDaoFactory {
    public JdbcHomeTaskImpl getJdbcHomeTaskDao() {
        return new JdbcHomeTaskImpl();
    }

    public inMemoryHomeTaskDao getInMemoryHomeTaskDao() {
        return new inMemoryHomeTaskDao();
    }

}
