package com.data.ss17.repository;


public interface AuthRepository {
    void register(String username, String password, String email, String phone);
    void login(String username, String password);
}
