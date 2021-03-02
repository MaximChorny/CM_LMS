package com.max.CM_LMS.domain.dao.inMemory;

import com.max.CM_LMS.domain.Lesson;
import com.max.CM_LMS.domain.User;
import com.max.CM_LMS.domain.dao.UserDao;
import com.max.CM_LMS.domain.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class inMemoryUserDao implements UserDao {
    @Override
    public List<User> getAll() {
        return new ArrayList<>(Persistence.getUsers().values());
    }

    @Override
    public User saveUser(User user) {
        int newId = Persistence.getNewId(Persistence.getUsers());
        user.setId(newId);
        Persistence.getUsers().put(newId, user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        if (Persistence.getUsers().containsKey(id)) {
            return Persistence.getUsers().get(id);
        }
        throw new NoSuchElementException("Wrong id");
    }

    @Override
    public boolean updateUser(User user) {
        int id = user.getId();
        Map<Integer, User> users = Persistence.getUsers();
        if (users.containsKey(id)) {
            users.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserById(int id) {
        Map<Integer, User> users = Persistence.getUsers();
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }
}
