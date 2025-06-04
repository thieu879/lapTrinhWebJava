package com.data.ss19.service.bt4;

import com.data.ss19.entity.bt4.ScreenRoom;

import java.util.List;

public interface ScreenRoomService {
    List<ScreenRoom> findByStatus(Boolean status);
    ScreenRoom findById(Long id);
    void save(ScreenRoom screenRoom);
    void update(ScreenRoom screenRoom);
    void delete(Long id);
    void createSeatsForRoom(ScreenRoom screenRoom);
}