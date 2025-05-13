package com.example.ss6.dao;

import com.example.ss6.model.User;

public interface UserDao {
    void addUser(User user);
    User authenticate(String username, String password);
}
