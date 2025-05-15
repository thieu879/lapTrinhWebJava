package com.example.ss9.service;

import com.example.ss9.dao.SeatDAO;
import com.example.ss9.dao.SeatDAOImpl;
import com.example.ss9.model.Seat;

import java.util.List;

public class SeatServiceImpl implements SeatService {
    private final SeatDAO seatDAO = new SeatDAOImpl();

    @Override
    public List<Seat> getSeatsByScreenRoom(Long screenRoomId) {
        return seatDAO.getSeatsByScreenRoom(screenRoomId);
    }
}