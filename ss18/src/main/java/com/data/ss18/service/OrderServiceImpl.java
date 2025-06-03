package com.data.ss18.service;

import com.data.ss18.entity.Order;
import com.data.ss18.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders(int page, int size) {
        return orderRepository.getAllOrders(page, size);
    }

    @Override
    public List<Order> searchOrders(String recipientName, Date startDate, Date endDate, String status, int page, int size) {
        return orderRepository.searchOrders(recipientName, startDate, endDate, status, page, size);
    }

    @Override
    public void updateOrderStatus(int orderId, String status) {
        orderRepository.updateOrderStatus(orderId, status);
    }

    @Override
    public long getTotalOrders() {
        return orderRepository.countOrders();
    }

    @Override
    public long getSearchResultCount(String recipientName, Date startDate, Date endDate, String status) {
        return orderRepository.countSearchResults(recipientName, startDate, endDate, status);
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderRepository.getOrderById(orderId);
    }
}
