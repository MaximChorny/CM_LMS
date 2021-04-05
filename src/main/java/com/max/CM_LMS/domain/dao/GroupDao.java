package com.max.CM_LMS.domain.dao;

import com.max.CM_LMS.domain.Group;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao {

    List<Group>getAll() throws SQLException;

    Group saveGroup(Group group) throws SQLException;

    Group getGroupById(int id) throws SQLException;

    boolean updateGroup(Group group) throws SQLException;

    boolean deleteGroupById(int id) throws SQLException;
}
