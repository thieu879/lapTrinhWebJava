package com.data.ss18.service;

import com.data.ss18.entity.Customer;
import com.data.ss18.repository.AuthRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public Customer getCustomerByUsername(String username) {
        return authRepository.getCustomerByUsername(username);
    }

    @Override
    public List<Customer> getAllCustomers(int pageNumber, int pageSize) {
        return authRepository.getAllCustomers(pageNumber, pageSize);
    }

    @Override
    public long totalCustomersCount() {
        return authRepository.totalCustomersCount();
    }
    @Override
    public void updateStatus(int id, int status) {
        authRepository.updateStatus(id, status);
    }

    @Override
    public void updateCustomer(Customer customer) {
        authRepository.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return authRepository.getCustomerById(id);
    }
    @Override
    public List<Customer> searchCustomers(String keyword, int page, int size) {
        return authRepository.searchCustomers(keyword, page, size);
    }

    @Override
    public long countSearchCustomers(String keyword) {
        return authRepository.countSearchCustomers(keyword);
    }
}

