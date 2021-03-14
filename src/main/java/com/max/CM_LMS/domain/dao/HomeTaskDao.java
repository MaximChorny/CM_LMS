package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.HomeTask;

import java.util.List;

public interface HomeTaskDao {
    List<HomeTaskDao> getAll();

    HomeTask saveHomeTask(HomeTask hw);

    HomeTask geHomeTaskById(int id);

    boolean updateHomeTask(HomeTask homew);

    boolean deleteHomeTaskById(int id);
}
