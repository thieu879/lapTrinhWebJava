package com.example.ss5.controller.Bt4;

import com.example.ss5.model.Students;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete-student")
public class DeleteStudentController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Students> studentList = (List<Students>) getServletContext().getAttribute("studentList");

        studentList.removeIf(s -> s.getId() == id);

        response.sendRedirect("/students");
    }
}
