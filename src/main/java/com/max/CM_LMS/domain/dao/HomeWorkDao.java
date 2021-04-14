package com.max.CM_LMS.domain.dao;



import com.max.CM_LMS.domain.HomeWork;

import java.sql.SQLException;
import java.util.List;

public interface HomeWorkDao {
    List<HomeWork> getAll() throws Exception;

    HomeWork save(HomeWork homeWork) throws Exception;

    HomeWork getHomeWork(int id) throws Exception;

    boolean updateHomeWork(HomeWork homeWork) throws Exception;

    boolean deleteHomeWorkById(int id) throws Exception;


}
