package com.example.ss9.dao;

import com.example.ss9.model.Seat;
import com.example.ss9.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeatDAOImpl implements SeatDAO {
    @Override
    public List<Seat> getSeatsByScreenRoom(Long screenRoomId) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Seat> seats = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_seats_by_screen_room(?)}");
            callSt.setLong(1, screenRoomId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getLong("id"),
                        rs.getLong("screen_room_id"),
                        rs.getDouble("price"),
                        rs.getString("status")
                );
                seats.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return seats;
    }
}