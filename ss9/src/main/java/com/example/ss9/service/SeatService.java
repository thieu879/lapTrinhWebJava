package com.example.ss9.service;

import com.example.ss9.model.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
}