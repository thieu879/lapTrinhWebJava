package com.example.ss10.model;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class Ticket {
    private String movieTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date showTime;
    private List<String> seats;
    private double totalAmount;

    public Ticket() {}

    public Ticket(String movieTitle, Date showTime, List<String> seats, double totalAmount) {
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.seats = seats;
        this.totalAmount = totalAmount;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

