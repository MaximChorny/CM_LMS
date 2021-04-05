package com.max.CM_LMS.domain.dao;



import com.max.CM_LMS.domain.HomeWork;

import java.sql.SQLException;
import java.util.List;

public interface HomeWorkDao {
    List<HomeWork> getAll() throws SQLException;

    HomeWork save(HomeWork homeWork) throws SQLException;

    HomeWork getHomeWork(int id) throws SQLException;

    boolean updateHomeWork(HomeWork homeWork) throws SQLException;

    boolean deleteHomeWorkById(int id) throws SQLException;


}
