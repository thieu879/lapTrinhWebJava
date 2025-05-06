package com.example.ss2.bt3;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ForwardServlet", value = "/ForwardServlet")
public class ForwardServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/formInputMess.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String messenger = request.getParameter("messenger");

        request.setAttribute("messenger", messenger);

        request.getRequestDispatcher("/WEB-INF/display.jsp").forward(request, response);
    }

    public void destroy() {
    }
}