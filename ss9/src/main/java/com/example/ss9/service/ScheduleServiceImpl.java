package com.example.ss9.service;

import com.example.ss9.dao.ScheduleDAO;
import com.example.ss9.dao.ScheduleDAOImpl;
import com.example.ss9.model.Schedule;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    @Override
    public List<Schedule> findAllSchedulesByMovie(String movieTitle) {
        return scheduleDAO.findAllSchedulesByMovie(movieTitle);
    }
}