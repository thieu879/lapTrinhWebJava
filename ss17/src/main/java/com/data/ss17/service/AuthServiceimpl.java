package com.data.ss17.service;

import com.data.ss17.repository.AuthRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuthServiceimpl implements AuthService {
    private AuthRepository authRepository;
    public AuthServiceimpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }
    @Override
    public void register(String username, String password, String email, String phone) {
        authRepository.register( username, password, email, phone);
    }

    @Override
    public void login(String username, String password) {
        authRepository.login(username, password);
    }
}
