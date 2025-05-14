package com.example.ss8.controller.bt6;

import com.example.ss8.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    // Khởi tạo sẵn vài nhân viên mẫu
    public EmployeeController() {
        employeeList.add(new Employee("Nguyen Van A", "a@gmail.com", "Developer"));
        employeeList.add(new Employee("Tran Thi B", "b@yahoo.com", "Tester"));
    }

    @GetMapping
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employeeList);
        return "/bt6/listEmployee";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "/bt6/addEmployee";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeList.add(employee);
        model.addAttribute("message", "Thêm nhân viên thành công!");
        model.addAttribute("employees", employeeList);
        return "/bt6/listEmployee";
    }
}

