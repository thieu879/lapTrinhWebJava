package com.data.ss14.dao.bt7;

import com.data.ss14.model.bt7.User;

public interface UserDAO {
    User findByUsernameAndPassword(String username, String password);
}

