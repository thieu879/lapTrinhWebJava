package com.example.ss4.bt8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RevenueServlet", value = "/RevenueServlet")
public class RevenueServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Revenue> revenueList = new ArrayList<>();
        revenueList.add(new Revenue("January", 1200));
        revenueList.add(new Revenue("February", 1800));
        revenueList.add(new Revenue("March", 2300));
        revenueList.add(new Revenue("April", 4000));
        revenueList.add(new Revenue("May", 500));

        int total = 0;
        for (Revenue r : revenueList) {
            total += r.getAmount();
        }

        request.setAttribute("revenues", revenueList);
        request.setAttribute("totalRevenue", total);

        request.getRequestDispatcher("/bt/bt8/revenue.jsp").forward(request, response);
    }
}
