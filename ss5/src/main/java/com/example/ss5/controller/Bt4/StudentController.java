package com.example.ss5.controller.Bt4;

import com.example.ss5.model.Students;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    private List<Students> studentList;

    public void init() {
        studentList = new ArrayList<>();
        studentList.add(new Students(1, "An", 20, "Hà Nội"));
        studentList.add(new Students(2, "Bình", 22, "Đà Nẵng"));
        studentList.add(new Students(3, "Cường", 21, "TP.HCM"));
        getServletContext().setAttribute("studentList", studentList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<Students> studentList = (List<Students>) getServletContext().getAttribute("studentList");
        int page = 1;
        int studentsPerPage = 1;

        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException ignored) {}
        }

        int totalStudents = studentList.size();
        int totalPages = (int) Math.ceil((double) totalStudents / studentsPerPage);

        int start = (page - 1) * studentsPerPage;
        int end = Math.min(start + studentsPerPage, totalStudents);

        List<Students> currentPageList = studentList.subList(start, end);

        request.setAttribute("currentPageList", currentPageList);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("/view/bt4,5/studentList.jsp").forward(request, response);
    }
}
