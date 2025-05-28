package com.data.ss14.dao.bt6;

import com.data.ss14.model.bt6.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    List<User> getAllUsers();
}


