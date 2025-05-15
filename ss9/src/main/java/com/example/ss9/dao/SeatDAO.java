package com.example.ss9.dao;

import com.example.ss9.model.Seat;

import java.util.List;

public interface SeatDAO {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
}