package com.max.CM_LMS.domain.dao.inMemory;


import com.max.CM_LMS.domain.HomeworkTask;
import com.max.CM_LMS.domain.dao.HomeworkTaskDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class inMemoryHomeworkTaskDao implements HomeworkTaskDao {

    @Override
    public List<HomeworkTaskDao> getAll() {
        return new ArrayList(Persistence.getHomeworkTasks().values());
    }

    @Override
    public HomeworkTask saveHomeworkTask(HomeworkTask hw) {
        int newId = Persistence.getNewId(Persistence.getHomeworkTasks());
        hw.setId(newId);
        Persistence.getHomeworkTasks().put(newId, hw);
        return hw;
    }

    @Override
    public HomeworkTask geHomeworkTaskById(int id) {
        if (Persistence.getHomeworkTasks().containsKey(id)) {
            return Persistence.getHomeworkTasks().get(id);
        }
        throw new NoSuchElementException("Wrong id");
    }

    @Override
    public boolean updateHomeworkTask(HomeworkTask homew) {
        int id = homew.getId();
        Map<Integer, HomeworkTask> hw = Persistence.getHomeworkTasks();
        if (hw.containsKey(id)) {
            hw.put(id, homew);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHomeworkTaskById(int id) {
        Map<Integer, HomeworkTask> hw = Persistence.getHomeworkTasks();
        if (hw.containsKey(id)) {
            hw.remove(id);
            return true;
        }
        return false;
    }

}
