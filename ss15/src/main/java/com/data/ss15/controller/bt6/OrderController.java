package com.data.ss15.controller.bt6;

import com.data.ss15.model.bt6.Order;
import com.data.ss15.service.bt6.OrderService;
import com.data.ss15.service.bt6.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/orders")
public class OrderController extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/bt6/order-form.jsp").forward(req, resp);
                break;
            case "edit":
                String id = req.getParameter("id");
                Order order = orderService.getOrderById(id);
                req.setAttribute("order", order);
                req.getRequestDispatcher("/bt6/order-form.jsp").forward(req, resp);
                break;
            case "delete":
                id = req.getParameter("id");
                orderService.deleteOrder(id);
                resp.sendRedirect("orders");
                break;
            default:
                List<Order> list = orderService.getAllOrders();
                req.setAttribute("orders", list);
                req.getRequestDispatcher("/bt6/order-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idOrder");
        String idUser = req.getParameter("idUser");
        String strDate = req.getParameter("orderDate");
        String status = req.getParameter("status");

        Date orderDate = null;
        try {
            orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Order order = new Order(id, idUser, orderDate, status);

        String action = req.getParameter("action");
        if ("edit".equals(action)) {
            orderService.updateOrder(order);
        } else {
            orderService.addOrder(order);
        }
        resp.sendRedirect("orders");
    }
}



