package com.data.ss15.service.bt6;

import com.data.ss15.dao.bt6.OrderDAO;
import com.data.ss15.dao.bt6.OrderDAOImpl;
import com.data.ss15.model.bt6.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public Order getOrderById(String id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDAO.insertOrder(order);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public boolean deleteOrder(String id) {
        return orderDAO.deleteOrder(id);
    }
}

