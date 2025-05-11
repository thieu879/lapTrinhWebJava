package com.example.ss5.controller.Bt6;

import com.example.ss5.model.Students;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/listStudent")
public class StudentController extends HttpServlet {
    private List<Students> studentList;

    @Override
    public void init() {
        studentList = new ArrayList<>();
        studentList.add(new Students(1, "An", 20, "Hà Nội"));
        studentList.add(new Students(2, "Bình", 22, "Đà Nẵng"));
        getServletContext().setAttribute("studentList", studentList);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/view/bt6/login.jsp");
            return;
        }

        request.getRequestDispatcher("/view/bt6/studentLists.jsp").forward(request, response);
    }
}
