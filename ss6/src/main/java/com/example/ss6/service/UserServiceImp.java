package com.example.ss6.service;

import com.example.ss6.dao.UserDao;
import com.example.ss6.dao.UserDaoImp;
import com.example.ss6.model.User;

public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp() {
        userDao = new UserDaoImp();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User authenticate(String username, String password) {
        return userDao.authenticate(username, password);
    }
}
