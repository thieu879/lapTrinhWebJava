package com.data.ss14.controller.bt8;

import com.data.ss14.model.bt8.Order;
import com.data.ss14.service.bt8.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("order", new Order());
        return "/bt8/orderForm";
    }

    @PostMapping
    public String placeOrder(@ModelAttribute Order order, HttpSession session, Model model) {
        orderService.processOrder(order);

        session.setAttribute("currentOrder", order);
        model.addAttribute("message", "Đặt hàng thành công!");
        return "/bt8/orderSuccess";
    }

    @GetMapping("/view")
    public String viewOrder(HttpSession session, Model model) {
        Order order = (Order) session.getAttribute("currentOrder");
        if (order == null) {
            model.addAttribute("message", "Không có đơn hàng nào trong phiên làm việc.");
        } else {
            model.addAttribute("order", order);
        }
        return "/bt8/orderView";
    }
}

