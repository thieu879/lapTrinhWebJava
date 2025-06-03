package com.data.ss18.controller;

import com.data.ss18.entity.Customer;
import com.data.ss18.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserManagementControlller {
    private final AuthService authService;
    public UserManagementControlller(AuthService authService) {
        this.authService = authService;
    }
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 5;
    @GetMapping("/user-management")
    public String userManagement(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String search // Thêm tham số search
    ) {
        page = Math.max(DEFAULT_PAGE, page);
        size = Math.max(1, size);

        long totalCustomer;
        List<Customer> customers;

        if (search != null && !search.trim().isEmpty()) {
            customers = authService.searchCustomers(search, page, size);
            totalCustomer = authService.countSearchCustomers(search);
            model.addAttribute("search", search);
        } else {
            totalCustomer = authService.totalCustomersCount();
            customers = authService.getAllCustomers(page, size);
        }

        int totalPages = (int) Math.ceil((double) totalCustomer / size);
        page = Math.min(page, totalPages);

        model.addAttribute("users", customers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "user-management";
    }
    @GetMapping("/user-management/status")
    public String changeStatus(@RequestParam int id, @RequestParam int status) {
        authService.updateStatus(id, status);
        return "redirect:/user-management";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        Customer customer = authService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String updateUser(Customer customer) {
        authService.updateCustomer(customer);
        return "redirect:/user-management";
    }

}
