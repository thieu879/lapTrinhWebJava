package com.example.ss6.dao;

import com.example.ss6.model.Employee;
import com.example.ss6.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public List<Employee> getEmployees(int page, int pageSize, String sortField, String sortOrder) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_employees_paginated(?,?,?,?)}");
            callSt.setInt(1, page);
            callSt.setInt(2, pageSize);
            callSt.setString(3, sortField);
            callSt.setString(4, sortOrder);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public int getTotalEmployees() {
        Connection conn = null;
        CallableStatement callSt = null;
        int total = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call count_employees(?)}");
            callSt.registerOutParameter(1, Types.INTEGER);
            callSt.execute();
            total = callSt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return total;
    }

    @Override
    public void addEmployee(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_employee(?,?,?,?,?,?)}");
            callSt.setString(1, employee.getName());
            callSt.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            callSt.setString(3, employee.getPhone());
            callSt.setString(4, employee.getEmail());
            callSt.setDouble(5, employee.getSalary());
            callSt.setString(6, employee.getPosition());
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_employee(?,?,?,?,?,?,?)}");
            callSt.setInt(1, employee.getId());
            callSt.setString(2, employee.getName());
            callSt.setDate(3, new java.sql.Date(employee.getBirthday().getTime()));
            callSt.setString(4, employee.getPhone());
            callSt.setString(5, employee.getEmail());
            callSt.setDouble(6, employee.getSalary());
            callSt.setString(7, employee.getPosition());
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_employee(?)}");
            callSt.setInt(1, id);
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public List<Employee> searchEmployees(String searchTerm, int page, int pageSize, String sortField, String sortOrder) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_employees(?,?,?,?,?)}");
            callSt.setString(1, searchTerm);
            callSt.setInt(2, page);
            callSt.setInt(3, pageSize);
            callSt.setString(4, sortField);
            callSt.setString(5, sortOrder);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public int getTotalSearchResults(String searchTerm) {
        Connection conn = null;
        CallableStatement callSt = null;
        int total = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call count_search_employees(?,?)}");
            callSt.setString(1, searchTerm);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            total = callSt.getInt(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return total;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Employee employee = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_employee_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employee;
    }
}
