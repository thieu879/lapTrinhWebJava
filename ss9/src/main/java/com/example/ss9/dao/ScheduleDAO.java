package com.example.ss9.dao;

import com.example.ss9.model.Schedule;

import java.util.List;

public interface ScheduleDAO {
    List<Schedule> findAllSchedulesByMovie(String movieTitle);
}