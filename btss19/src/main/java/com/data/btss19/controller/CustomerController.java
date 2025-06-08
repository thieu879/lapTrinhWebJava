package com.data.btss19.controller;

import com.data.btss19.config.CloudinaryService;
import com.data.btss19.entity.Customer;
import com.data.btss19.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/add")
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer,
                              @RequestParam(value = "image", required = false) MultipartFile fileImage
    ) {

        try {
            if (fileImage != null && !fileImage.isEmpty()) {
                String imageUrl = cloudinaryService.uploadImage(fileImage);
                customer.setFileImage(imageUrl);
            }
            customerService.saveCustomer(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute("customer") Customer customer,
                               @RequestParam(value = "image", required = false) MultipartFile fileImage) {
        try {
            if (fileImage != null && !fileImage.isEmpty()) {
                String imageUrl = cloudinaryService.uploadImage(fileImage);
                customer.setFileImage(imageUrl);
            }
            customerService.updateCustomer(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("keyword") String keyword, Model model) {
        List<Customer> customers = customerService.searchCustomers(keyword);
        model.addAttribute("customers", customers);
        return "customer-list";
    }
}

