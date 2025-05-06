package com.example.ss1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bt5", value = "/Bt5")
public class Bt5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int result = 10 / 0;
            response.getWriter().println("Kết quả: " + result);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Đã xảy ra lỗi: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/bt5.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}