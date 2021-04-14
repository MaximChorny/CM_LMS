package com.max.CM_LMS.domain.dao;


import com.max.CM_LMS.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAll() throws SQLException, Exception;

    User saveUser(User user) throws SQLException, Exception;

    User getUserById(int id) throws SQLException, Exception;

    boolean updateUser(User user) throws Exception;

    boolean deleteUserById(int id) throws Exception;
}
