package com.data.ss14.service.bt7;

import com.data.ss14.dao.bt7.UserDAO;
import com.data.ss14.dao.bt7.UserDAOImpl;
import com.data.ss14.model.bt7.User;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public User login(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }
}

