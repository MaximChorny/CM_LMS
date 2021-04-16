package com.max.CM_LMS.domain.dao.factory;


import com.max.CM_LMS.domain.dao.inDataBase.JdbcHomeWorkDaoImpl;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryHomeWorkDao;

public class HomeWorkDaoFactory {
    public JdbcHomeWorkDaoImpl getJdbcHomeWorkDao() {
        return new JdbcHomeWorkDaoImpl();
    }

    public inMemoryHomeWorkDao getInMemoryHomeWorkDao() {
        return new inMemoryHomeWorkDao();
    }

}
