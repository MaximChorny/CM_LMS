package com.max.CM_LMS.domain.dao;


import com.max.CM_LMS.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User saveUser(User user);

    User getUserById(int id);

    boolean updateUser(User user);

    boolean deleteUserById(int id);
}
