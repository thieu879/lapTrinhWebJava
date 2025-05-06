package com.example.ss1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bt6", value = "/Bt6")
public class Bt6 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/formRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String studentClass = request.getParameter("studentClass");
        String vehicleType = request.getParameter("vehicleType");
        String licensePlate = request.getParameter("licensePlate");

        boolean isSuccess = fullName != null && studentClass != null &&
                vehicleType != null && licensePlate != null &&
                !fullName.isEmpty() && !studentClass.isEmpty() &&
                !vehicleType.isEmpty() && !licensePlate.isEmpty();

        // Kiểm tra định dạng biển số xe (ví dụ: 12-AB-12345 hoặc 12-A-1234)
        boolean isValidLicensePlate = licensePlate != null && licensePlate.matches("[0-9]{2}-[A-Z]{1,2}-[0-9]{4,5}");
        isSuccess = isSuccess && isValidLicensePlate;

        request.setAttribute("isSuccess", isSuccess);
        request.setAttribute("fullName", fullName);
        request.setAttribute("studentClass", studentClass);
        request.setAttribute("vehicleType", vehicleType);
        request.setAttribute("licensePlate", licensePlate);

        // Chuyển tiếp đến trang kết quả
        request.getRequestDispatcher("/WEB-INF/resultRegister.jsp").forward(request, response);
    }

    public void destroy() {
    }
}