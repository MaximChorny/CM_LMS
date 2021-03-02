package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Group;

import java.util.List;

public interface GroupDao {

    List<Group>getAll();

    Group saveGroup(Group group);

    Group getGroupById(int id);

    boolean updateGroup(Group group);

    boolean deleteGroupById(int id);
}
