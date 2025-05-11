package com.example.ss5.controller.Bt4;

import com.example.ss5.model.Students;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit-student")
public class EditStudentController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        List<Students> list = (List<Students>) getServletContext().getAttribute("studentList");

        for (Students s : list) {
            if (s.getId() == id) {
                request.setAttribute("student", s);
                break;
            }
        }

        request.getRequestDispatcher("/view/bt4,5/editStudent.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        List<Students> list = (List<Students>) getServletContext().getAttribute("studentList");
        for (Students s : list) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);
                break;
            }
        }

        response.sendRedirect("/students");
    }
}
