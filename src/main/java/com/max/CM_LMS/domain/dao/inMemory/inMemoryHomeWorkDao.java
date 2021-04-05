package com.max.CM_LMS.domain.dao.inMemory;

import com.max.CM_LMS.domain.HomeWork;
import com.max.CM_LMS.domain.dao.HomeWorkDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class inMemoryHomeWorkDao implements HomeWorkDao {
    @Override
    public List<HomeWork> getAll() {
        return new ArrayList<>(Persistence.getHomeWorkMap().values());
    }

    @Override
    public HomeWork save(HomeWork homeWork) {
        int newId = Persistence.getNewId(Persistence.getHomeWorkMap());
        homeWork.setId(newId);
        Persistence.getHomeWorkMap().put(newId, homeWork);
        return homeWork;
    }

    @Override
    public HomeWork getHomeWork(int id) {
        if(Persistence.getHomeWorkMap().containsKey(id)){
            return Persistence.getHomeWorkMap().get(id);
        }
        return null;
    }

    @Override
    public boolean updateHomeWork(HomeWork homeWork) {
         int id = homeWork.getId();
         Map<Integer,HomeWork> hw = Persistence.getHomeWorkMap();
         if(hw.containsKey(id)){
             hw.put(id, homeWork);
             return true;
         }
        return false;
    }

    @Override
    public boolean deleteHomeWorkById(int id) {
        Map<Integer, HomeWork> hw = Persistence.getHomeWorkMap();
        if(hw.containsKey(id)){
            hw.remove(id);
            return true;
        }
        return false;
    }
}
