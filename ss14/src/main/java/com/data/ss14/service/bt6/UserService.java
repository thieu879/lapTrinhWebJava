package com.data.ss14.service.bt6;

import com.data.ss14.model.bt6.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> getAllUsers();
}

