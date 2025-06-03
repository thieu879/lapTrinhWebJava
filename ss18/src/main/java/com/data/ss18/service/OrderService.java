package com.data.ss18.service;

import com.data.ss18.entity.Order;
import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(int page, int size);
    List<Order> searchOrders(String recipientName, Date startDate, Date endDate, String status, int page, int size);
    void updateOrderStatus(int orderId, String status);
    long getTotalOrders();
    long getSearchResultCount(String recipientName, Date startDate, Date endDate, String status);
    Order getOrderById(int orderId);
}
