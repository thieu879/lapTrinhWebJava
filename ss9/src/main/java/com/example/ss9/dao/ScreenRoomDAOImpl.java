package com.example.ss9.dao;

import com.example.ss9.model.ScreenRoom;
import com.example.ss9.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class ScreenRoomDAOImpl implements ScreenRoomDAO {
    @Override
    public ScreenRoom getScreenRoomById(Long id) {
        Connection conn = null;
        CallableStatement callSt = null;
        ScreenRoom screenRoom = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_screen_room_by_id(?)}");
            callSt.setLong(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                screenRoom = new ScreenRoom(
                        rs.getLong("id"),
                        rs.getString("screen_room_name"),
                        rs.getInt("total_seat")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return screenRoom;
    }
}