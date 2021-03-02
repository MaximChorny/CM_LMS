package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.HomeworkTask;

import java.util.List;

public interface HomeworkTaskDao {
    List<HomeworkTaskDao> getAll();

    HomeworkTask saveHomeworkTask(HomeworkTask hw);

    HomeworkTask geHomeworkTaskById(int id);

    boolean updateHomeworkTask(HomeworkTask homew);

    boolean deleteHomeworkTaskById(int id);
}
