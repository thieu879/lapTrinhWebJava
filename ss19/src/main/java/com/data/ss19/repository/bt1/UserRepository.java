package com.data.ss19.repository.bt1;

import com.data.ss19.entity.bt1.User;

import java.util.List;

public interface UserRepository {
    User getCustomerByUsername(String username);
    List<User> getAllCustomers(int pageNumber, int pageSize);
    long totalCustomersCount();
    void updateStatus(int id, boolean status);
    void updateCustomer(User customer);
    User getCustomerById(int id);
    List<User> searchCustomers(String keyword, int page, int size);
    long countSearchCustomers(String keyword);
}


