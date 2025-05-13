package com.example.ss6.service;

import com.example.ss6.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int page, int pageSize, String sortField, String sortOrder);
    int getTotalEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> searchEmployees(String searchTerm, int page, int pageSize, String sortField, String sortOrder);
    int getTotalSearchResults(String searchTerm);
    Employee getEmployeeById(int id);
}