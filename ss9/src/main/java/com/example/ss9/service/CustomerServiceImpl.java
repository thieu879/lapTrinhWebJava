package com.example.ss9.service;

import com.example.ss9.dao.CustomerDAO;
import com.example.ss9.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public Long validateCustomer(String username, String password) {
        return customerDAO.validateCustomer(username, password);
    }
}