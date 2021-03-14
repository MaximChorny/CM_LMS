package com.max.CM_LMS.domain.dao.inMemory;


import com.max.CM_LMS.domain.HomeTask;
import com.max.CM_LMS.domain.dao.HomeTaskDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class inMemoryHomeTaskDao implements HomeTaskDao {

    @Override
    public List<HomeTaskDao> getAll() {
        return new ArrayList(Persistence.getHomeworkTasks().values());
    }

    @Override
    public HomeTask saveHomeTask(HomeTask hw) {
        int newId = Persistence.getNewId(Persistence.getHomeworkTasks());
        hw.setId(newId);
        Persistence.getHomeworkTasks().put(newId, hw);
        return hw;
    }

    @Override
    public HomeTask geHomeTaskById(int id) {
        if (Persistence.getHomeworkTasks().containsKey(id)) {
            return Persistence.getHomeworkTasks().get(id);
        }
       return null;
    }

    @Override
    public boolean updateHomeTask(HomeTask homew) {
        int id = homew.getId();
        Map<Integer, HomeTask> hw = Persistence.getHomeworkTasks();
        if (hw.containsKey(id)) {
            hw.put(id, homew);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHomeTaskById(int id) {
        Map<Integer, HomeTask> hw = Persistence.getHomeworkTasks();
        if (hw.containsKey(id)) {
            hw.remove(id);
            return true;
        }
        return false;
    }

}
