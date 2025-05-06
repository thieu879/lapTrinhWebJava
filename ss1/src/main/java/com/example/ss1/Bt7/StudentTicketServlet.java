package com.example.ss1.Bt7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentTicketServlet", value = "/list-students")
public class StudentTicketServlet extends HttpServlet {
    private static final List<Student> studentList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        if (studentList.isEmpty()) {
            studentList.add(new Student("Nguyễn Văn A", "CNTT1", "Xe máy", "29-A1-12345"));
            studentList.add(new Student("Trần Thị B", "CNTT2", "Xe đạp", "30-B1-54321"));
            studentList.add(new Student("Lê Văn C", "CNTT3", "Xe máy", "29-A2-67890"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/WEB-INF/listStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}