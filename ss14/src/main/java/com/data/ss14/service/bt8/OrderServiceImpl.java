package com.data.ss14.service.bt8;

import com.data.ss14.dao.bt8.OrderDAO;
import com.data.ss14.model.bt8.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void processOrder(Order order) {
        orderDAO.saveOrder(order);
    }
}

