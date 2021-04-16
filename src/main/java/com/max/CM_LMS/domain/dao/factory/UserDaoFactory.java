package com.max.CM_LMS.domain.dao.factory;


import com.max.CM_LMS.domain.dao.inDataBase.JdbcUserDaoImpl;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryUserDao;

public class UserDaoFactory {
    public JdbcUserDaoImpl getJdbcUserDao() {
        return new JdbcUserDaoImpl();
    }

    public inMemoryUserDao getInMemoryUserDao() {
        return new inMemoryUserDao();
    }
}
