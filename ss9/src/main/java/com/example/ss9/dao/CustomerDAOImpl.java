package com.example.ss9.dao;
import com.example.ss9.model.Customer;
import com.example.ss9.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Long validateCustomer(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        Long customerId = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call validate_customer(?,?,?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            callSt.registerOutParameter(3, java.sql.Types.BIGINT);
            callSt.execute();
            customerId = callSt.getLong(3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return customerId;
    }
}