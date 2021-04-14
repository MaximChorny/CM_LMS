package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.HomeTask;

import java.sql.SQLException;
import java.util.List;

public interface HomeTaskDao {
    List<HomeTask> getAll() throws Exception;

    HomeTask saveHomeTask(HomeTask homeTask) throws Exception;

    HomeTask getHomeTaskById(int id) throws Exception;

    boolean updateHomeTask(HomeTask homeTask) throws Exception;

    boolean deleteHomeTaskById(int id) throws Exception;
}
