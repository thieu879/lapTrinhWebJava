package com.example.ss5.controller.Bt2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/view/bt2/studentForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.setAttribute("address", address);

        request.getRequestDispatcher("/view/bt2/confirmation.jsp").forward(request, response);
    }
}

