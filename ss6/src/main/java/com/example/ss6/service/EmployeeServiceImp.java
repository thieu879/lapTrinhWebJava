package com.example.ss6.service;

import com.example.ss6.dao.EmployeeDao;
import com.example.ss6.dao.EmployeeDaoImp;
import com.example.ss6.model.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }

    @Override
    public List<Employee> getEmployees(int page, int pageSize, String sortField, String sortOrder) {
        return employeeDao.getEmployees(page, pageSize, sortField, sortOrder);
    }

    @Override
    public int getTotalEmployees() {
        return employeeDao.getTotalEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchEmployees(String searchTerm, int page, int pageSize, String sortField, String sortOrder) {
        return employeeDao.searchEmployees(searchTerm, page, pageSize, sortField, sortOrder);
    }

    @Override
    public int getTotalSearchResults(String searchTerm) {
        return employeeDao.getTotalSearchResults(searchTerm);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }
}
