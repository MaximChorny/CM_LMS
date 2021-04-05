package com.max.CM_LMS.domain.dao;


import com.max.CM_LMS.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAll() throws SQLException;

    User saveUser(User user) throws SQLException;

    User getUserById(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    boolean deleteUserById(int id) throws SQLException;
}
