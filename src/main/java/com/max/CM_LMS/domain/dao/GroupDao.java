package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Group;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao {

    List<Group>getAll() throws Exception;

    Group saveGroup(Group group) throws Exception;

    Group getGroupById(int id) throws Exception;

    boolean updateGroup(Group group) throws Exception;

    boolean deleteGroupById(int id) throws Exception;
}
