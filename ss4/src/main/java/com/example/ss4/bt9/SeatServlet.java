package com.example.ss4.bt9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/seats")
public class SeatServlet extends HttpServlet {
    private List<Seat> seats;

    @Override
    public void init() {
        seats = new ArrayList<>();

        for (char row = 'A'; row <= 'E'; row++) {
            for (int col = 1; col <= 10; col++) {
                String id = row + String.valueOf(col);
                seats.add(new Seat(id, id, 50000, false));
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("seats", seats);
        request.getRequestDispatcher("/bt/bt9/seat.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedSeats = request.getParameterValues("selectedSeats");
        double total = 0;

        if (selectedSeats != null) {
            for (String id : selectedSeats) {
                for (Seat seat : seats) {
                    if (seat.getId().equals(id) && !seat.isStatus()) {
                        total += seat.getPrice();
                    }
                }
            }
        }

        request.setAttribute("seats", seats);
        request.setAttribute("total", total);
        request.setAttribute("selected", selectedSeats);
        request.getRequestDispatcher("/bt/bt9/seat.jsp").forward(request, response);
    }
}
