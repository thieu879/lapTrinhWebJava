package com.example.ss5.controller.Bt3;

import com.example.ss5.model.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/student")
public class StudentController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/view/bt3/studentForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        boolean hasError = false;

        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("nameError", "Tên không được để trống");
            hasError = true;
        }

        int age = 0;
        if (ageStr == null || ageStr.trim().isEmpty()) {
            request.setAttribute("ageError", "Tuổi không được để trống");
            hasError = true;
        } else {
            try {
                age = Integer.parseInt(ageStr);
                if (age < 0 || age > 150) {
                    request.setAttribute("ageError", "Tuổi không hợp lệ");
                    hasError = true;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("ageError", "Tuổi phải là số");
                hasError = true;
            }
        }

        if (address == null || address.trim().isEmpty()) {
            request.setAttribute("addressError", "Địa chỉ không được để trống");
            hasError = true;
        }

        if (hasError) {
            request.getRequestDispatcher("/view/bt3/studentForm.jsp").forward(request, response);
        } else {
            Student student = new Student(name, age, address);
            request.setAttribute("student", student);
            request.getRequestDispatcher("/view/bt3/studentInfo.jsp").forward(request, response);
        }
    }
}
