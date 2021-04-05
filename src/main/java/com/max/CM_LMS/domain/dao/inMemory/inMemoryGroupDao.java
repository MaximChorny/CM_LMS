package com.max.CM_LMS.domain.dao.inMemory;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.dao.GroupDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class inMemoryGroupDao implements GroupDao {


    @Override
    public List<Group> getAll() {
        return  new ArrayList<>(  Persistence.getGroups().values());
    }

    @Override
    public Group saveGroup(Group group) {
        int newId = Persistence.getNewId(Persistence.getGroups());
        group.setId(newId);
        Persistence.getGroups().put(newId, group);
        return group;
    }

    @Override
    public Group getGroupById(int id) {
        if(Persistence.getGroups().containsKey(id)) {
            return Persistence.getGroups().get(id);
        }
        return null;
    }

    @Override
    public boolean updateGroup(Group group) {
        int id = group.getId();
        Map<Integer, Group> groups = Persistence.getGroups();
        if (groups.containsKey(id)) {
            groups.put(id, group);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGroupById(int id) {
        Map<Integer, Group> groups = Persistence.getGroups();
        if (groups.containsKey(id)) {
            groups.remove(id);
            return true;
        }
        return false;
    }
}
