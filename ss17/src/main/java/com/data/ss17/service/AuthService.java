package com.data.ss17.service;

public interface AuthService {
    void register(String username, String password, String email, String phone);
    void login(String username, String password);
}
