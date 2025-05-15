package com.example.ss9.service;

public interface TicketService {
    Long addTicket(Long customerId, Long scheduleId, Double totalMoney, String seatIds);
}