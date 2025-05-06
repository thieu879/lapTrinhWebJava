package com.example.ss1;import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bt3", value = "/Bt3")
public class Bt3 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = "Thiều";
        int age = 20;
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.getRequestDispatcher("/WEB-INF/bt3.jsp").forward(request, response);
    }

    public void destroy() {
    }
}