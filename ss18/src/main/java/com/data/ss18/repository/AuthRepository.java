package com.data.ss18.repository;

import com.data.ss18.entity.Customer;

import java.util.List;

public interface AuthRepository {
    void register(String username, String password, String email, String phone);
    void login(String username, String password);
    Customer getCustomerByUsername(String username);
    List<Customer> getAllCustomers(int pageNumber, int pageSize);
    long totalCustomersCount();
    void updateStatus(int id, int status);
    void updateCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> searchCustomers(String keyword, int page, int size);
    long countSearchCustomers(String keyword);
}

