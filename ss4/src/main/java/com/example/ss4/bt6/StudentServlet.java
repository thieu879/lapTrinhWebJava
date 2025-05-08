package com.example.ss4.bt6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    List<Student> students = new ArrayList<>();

    public void init() {
        students.add(new Student(1, "Nguyen Van A", 5.5, "Ha Noi"));
        students.add(new Student(2, "Nguyen Van B", 7.5, "Da Nang"));
        students.add(new Student(3, "Nguyen Van C", 9.0, "Ho Chi Minh"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int count = 0;
        for (Student s : students) {
            if (s.getPoint() > 7.0) {
                count++;
            }
        }
        request.setAttribute("count", count);
        request.setAttribute("studentList", students);

        request.getRequestDispatcher("/bt/bt6/listStudent.jsp").forward(request, response);
    }

    public void destroy() {
    }
}