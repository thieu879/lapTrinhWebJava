package com.data.ss18.controller;

import com.data.ss18.entity.Order;
import com.data.ss18.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class OrderManagementController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String orderManagement(
            @RequestParam(required = false) String recipientName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        List<Order> orders = orderService.searchOrders(recipientName, startDate, endDate, status, page, size);
        long total = orderService.getSearchResultCount(recipientName, startDate, endDate, status);
        int totalPages = (int) Math.ceil((double) total / size);

        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("recipientName", recipientName);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("status", status);

        return "order-management";
    }

    @PostMapping("/update-status")
    public String updateOrderStatus(
            @RequestParam int orderId,
            @RequestParam String status,
            @RequestParam int page,
            @RequestParam int size
    ) {
        orderService.updateOrderStatus(orderId, status);
        return "redirect:/admin/orders?page=" + page + "&size=" + size;
    }
}
