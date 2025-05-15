package com.example.ss9.dao;
import com.example.ss9.model.Schedule;
import com.example.ss9.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public List<Schedule> findAllSchedulesByMovie(String movieTitle) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Schedule> schedules = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_schedules_by_movie(?)}");
            callSt.setString(1, movieTitle);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getLong("id"),
                        rs.getString("movie_title"),
                        rs.getTimestamp("show_time"),
                        rs.getLong("screen_room_id"),
                        rs.getInt("available_seats"),
                        rs.getString("format"),
                        rs.getString("screen_room_name")
                );
                schedules.add(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return schedules;
    }
}