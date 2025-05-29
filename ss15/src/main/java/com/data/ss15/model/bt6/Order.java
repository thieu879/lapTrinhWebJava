package com.data.ss15.model.bt6;

import java.util.Date;

public class Order {
    private String idOrder;
    private String idUser;
    private Date orderDate;
    private String status;

    public Order() {}

    public Order(String idOrder, String idUser, Date orderDate, String status) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getIdOrder() { return idOrder; }
    public void setIdOrder(String idOrder) { this.idOrder = idOrder; }

    public String getIdUser() { return idUser; }
    public void setIdUser(String idUser) { this.idUser = idUser; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


