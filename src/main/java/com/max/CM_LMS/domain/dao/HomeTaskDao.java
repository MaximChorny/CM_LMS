package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.HomeTask;

import java.sql.SQLException;
import java.util.List;

public interface HomeTaskDao {
    List<HomeTask> getAll() throws SQLException;

    HomeTask saveHomeTask(HomeTask homeTask) throws SQLException;

    HomeTask getHomeTaskById(int id) throws SQLException;

    boolean updateHomeTask(HomeTask homeTask) throws SQLException;

    boolean deleteHomeTaskById(int id) throws SQLException;
}
