package com.max.CM_LMS.domain.dao.factory;

import com.max.CM_LMS.domain.dao.GroupDao;
import com.max.CM_LMS.domain.dao.inDataBase.JdbcGroupDaoImpl;
import com.max.CM_LMS.domain.dao.inMemory.inMemoryGroupDao;

public class GroupDaoFactory {

    public JdbcGroupDaoImpl getJdbcGroupDao() {
        return new JdbcGroupDaoImpl();
    }

    public inMemoryGroupDao getInMemoryGroupDao() {
        return new inMemoryGroupDao();
    }
}
