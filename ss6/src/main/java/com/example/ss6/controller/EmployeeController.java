package com.example.ss6.controller;

import com.example.ss6.model.Employee;
import com.example.ss6.service.EmployeeService;
import com.example.ss6.service.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService;
    private static final int PAGE_SIZE = 5;

    public EmployeeController() {
        employeeService = new EmployeeServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                req.getRequestDispatcher("/view/addEmployee.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Employee employee = employeeService.getEmployeeById(id);
                req.setAttribute("employee", employee);
                req.getRequestDispatcher("/view/updateEmployee.jsp").forward(req, resp);
                break;
            case "delete":
                employeeService.deleteEmployee(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/EmployeeController");
                break;
            case "list":
            default:
                displayEmployeeList(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                addEmployee(req, resp);
                break;
            case "update":
                updateEmployee(req, resp);
                break;
            case "search":
                searchEmployees(req, resp);
                break;
            default:
                displayEmployeeList(req, resp);
                break;
        }
    }

    private void displayEmployeeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        String sortField = req.getParameter("sortField") != null ? req.getParameter("sortField") : "name";
        String sortOrder = req.getParameter("sortOrder") != null ? req.getParameter("sortOrder") : "ASC";
        String searchTerm = req.getParameter("searchTerm");

        List<Employee> employees;
        int totalRecords;
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            employees = employeeService.searchEmployees(searchTerm, page, PAGE_SIZE, sortField, sortOrder);
            totalRecords = employeeService.getTotalSearchResults(searchTerm);
        } else {
            employees = employeeService.getEmployees(page, PAGE_SIZE, sortField, sortOrder);
            totalRecords = employeeService.getTotalEmployees();
        }

        int totalPages = (int) Math.ceil((double) totalRecords / PAGE_SIZE);
        req.setAttribute("employees", employees);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("sortField", sortField);
        req.setAttribute("sortOrder", sortOrder);
        req.setAttribute("searchTerm", searchTerm);
        req.getRequestDispatcher("/view/employeeList.jsp").forward(req, resp);
    }

    private void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = new Employee();
        employee.setName(req.getParameter("name"));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            employee.setBirthday(sdf.parse(req.getParameter("birthday")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        employee.setPhone(req.getParameter("phone"));
        employee.setEmail(req.getParameter("email"));
        employee.setSalary(Double.parseDouble(req.getParameter("salary")));
        employee.setPosition(req.getParameter("position"));
        employeeService.addEmployee(employee);
        resp.sendRedirect("/EmployeeController");
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(req.getParameter("id")));
        employee.setName(req.getParameter("name"));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            employee.setBirthday(sdf.parse(req.getParameter("birthday")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        employee.setPhone(req.getParameter("phone"));
        employee.setEmail(req.getParameter("email"));
        employee.setSalary(Double.parseDouble(req.getParameter("salary")));
        employee.setPosition(req.getParameter("position"));
        employeeService.updateEmployee(employee);
        resp.sendRedirect("/EmployeeController");
    }

    private void searchEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        displayEmployeeList(req, resp);
    }
}
