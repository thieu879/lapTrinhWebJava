package com.example.ss9.model;

import java.util.Date;
import java.util.List;

public class Ticket {
    private Long id;
    private Long customerId;
    private Long scheduleId;
    private List<Seat> listSeat;
    private Double totalMoney;
    private Date createdAt;

    public Ticket() {}

    public Ticket(Long id, Long customerId, Long scheduleId, List<Seat> listSeat, Double totalMoney, Date createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.scheduleId = scheduleId;
        this.listSeat = listSeat;
        this.totalMoney = totalMoney;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public Long getScheduleId() { return scheduleId; }
    public void setScheduleId(Long scheduleId) { this.scheduleId = scheduleId; }
    public List<Seat> getListSeat() { return listSeat; }
    public void setListSeat(List<Seat> listSeat) { this.listSeat = listSeat; }
    public Double getTotalMoney() { return totalMoney; }
    public void setTotalMoney(Double totalMoney) { this.totalMoney = totalMoney; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}