package com.example.ss9.service;

import com.example.ss9.dao.ScreenRoomDAO;
import com.example.ss9.dao.ScreenRoomDAOImpl;
import com.example.ss9.model.ScreenRoom;

public class ScreenRoomServiceImpl implements ScreenRoomService {
    private final ScreenRoomDAO screenRoomDAO = new ScreenRoomDAOImpl();

    @Override
    public ScreenRoom getScreenRoomById(Long id) {
        return screenRoomDAO.getScreenRoomById(id);
    }
}