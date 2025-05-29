package com.data.ss15.service.bt6;

import com.data.ss15.model.bt6.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(String id);
    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(String id);
}


