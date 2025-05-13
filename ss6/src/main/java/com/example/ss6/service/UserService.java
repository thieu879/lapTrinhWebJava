package com.example.ss6.service;

import com.example.ss6.model.User;

public interface UserService {
    void addUser(User user);
    User authenticate(String username, String password);
}
