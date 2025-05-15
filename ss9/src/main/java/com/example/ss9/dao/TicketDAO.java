package com.example.ss9.dao;

import com.example.ss9.model.Ticket;

public interface TicketDAO {
    Long addTicket(Long customerId, Long scheduleId, Double totalMoney, String seatIds);
}