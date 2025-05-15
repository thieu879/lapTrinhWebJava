package com.example.ss9.dao;

import com.example.ss9.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.CallableStatement;

public class TicketDAOImpl implements TicketDAO {
    @Override
    public Long addTicket(Long customerId, Long scheduleId, Double totalMoney, String seatIds) {
        Connection conn = null;
        CallableStatement callSt = null;
        Long ticketId = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call book_ticket(?,?,?,?,?)}");
            callSt.setLong(1, customerId);
            callSt.setLong(2, scheduleId);
            callSt.setDouble(3, totalMoney);
            callSt.setString(4, seatIds);
            callSt.registerOutParameter(5, java.sql.Types.BIGINT);
            callSt.execute();
            ticketId = callSt.getLong(5);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return ticketId;
    }
}