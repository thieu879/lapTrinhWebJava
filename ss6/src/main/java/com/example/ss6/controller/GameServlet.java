package com.example.ss6.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/bt5.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userChoice = request.getParameter("userChoice");

        String[] choices = {"Búa", "Kéo", "Lá"};
        int randomIndex = (int) (Math.random() * 3);
        String computerChoice = choices[randomIndex];

        String result;
        if (userChoice.equals(computerChoice)) {
            result = "Hòa!";
        } else if ((userChoice.equals("Búa") && computerChoice.equals("Kéo")) ||
                (userChoice.equals("Kéo") && computerChoice.equals("Lá")) ||
                (userChoice.equals("Lá") && computerChoice.equals("Búa"))) {
            result = "Bạn thắng!";
        } else {
            result = "Bạn thua!";
        }

        request.setAttribute("userChoice", userChoice);
        request.setAttribute("computerChoice", computerChoice);
        request.setAttribute("result", result);

        request.getRequestDispatcher("/view/bt5.jsp").forward(request, response);
    }
}