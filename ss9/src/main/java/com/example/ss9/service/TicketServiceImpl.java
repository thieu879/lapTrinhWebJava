package com.example.ss9.service;

import com.example.ss9.dao.TicketDAO;
import com.example.ss9.dao.TicketDAOImpl;

public class TicketServiceImpl implements TicketService {
    private final TicketDAO ticketDAO = new TicketDAOImpl();

    @Override
    public Long addTicket(Long customerId, Long scheduleId, Double totalMoney, String seatIds) {
        return ticketDAO.addTicket(customerId, scheduleId, totalMoney, seatIds);
    }
}