package com.data.ss19.controller.bt1;

import com.data.ss19.entity.bt1.User;
import com.data.ss19.service.bt1.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
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
        List<User> customers;

        if (search != null && !search.trim().isEmpty()) {
            customers = userService.searchCustomers(search, page, size);
            totalCustomer = userService.countSearchCustomers(search);
            model.addAttribute("search", search);
        } else {
            totalCustomer = userService.totalCustomersCount();
            customers = userService.getAllCustomers(page, size);
        }

        int totalPages = (int) Math.ceil((double) totalCustomer / size);
        page = Math.min(page, totalPages);

        model.addAttribute("users", customers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "/bt1/user-management";
    }
    @GetMapping("/user-management/status")
    public String changeStatus(@RequestParam int id, @RequestParam boolean status) {
        userService.updateStatus(id, status);
        return "redirect:/user-management";
    }
    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable int id, Model model) {
        User user = userService.getCustomerById(id);
        model.addAttribute("customer", user);
        return "/bt1/edit-user";
    }

    @PostMapping("/editUser")
    public String updateUser(User user) {
        userService.updateCustomer(user);
        return "redirect:/bt1/user-management";
    }
}
