package com.max.CM_LMS.domain.dao.factory;

import com.max.CM_LMS.domain.dao.inDataBase.JdbcPostDaoImpl;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryPostDao;

public class PostDaoFactory {
    public JdbcPostDaoImpl getJdbcPostDao() {
        return new JdbcPostDaoImpl();
    }

    public inMemoryPostDao getInMemoryPostDao() {
        return new inMemoryPostDao();
    }

}
