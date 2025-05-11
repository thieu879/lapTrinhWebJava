package com.example.ss5.controller.Bt6;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/view/bt6/login.jsp");
    }
}
