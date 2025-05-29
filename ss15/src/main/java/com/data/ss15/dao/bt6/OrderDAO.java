package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders();
    Order getOrderById(String id);
    boolean insertOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(String id);
}


