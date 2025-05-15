package com.example.ss9.model;

public class Seat {
    private Long id;
    private Long screenRoomId;
    private Double price;
    private String status;

    public Seat() {}

    public Seat(Long id, Long screenRoomId, Double price, String status) {
        this.id = id;
        this.screenRoomId = screenRoomId;
        this.price = price;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getScreenRoomId() { return screenRoomId; }
    public void setScreenRoomId(Long screenRoomId) { this.screenRoomId = screenRoomId; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}