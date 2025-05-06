package com.example.ss2.bt1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LifecycleServlet", value = "/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        super.init();
        System.out.println("LifecycleServlet: init() called");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>LifecycleServlet: doGet() called</h1>");
        out.println("</body></html>");

        System.out.println("LifecycleServlet: doGet() called");
    }

    public void destroy() {
        System.out.println("LifecycleServlet: destroy() called");
    }
}