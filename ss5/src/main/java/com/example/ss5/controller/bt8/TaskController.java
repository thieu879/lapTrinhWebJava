package com.example.ss5.controller.bt8;

import com.example.ss5.model.Task;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tasks")
public class TaskController extends HttpServlet {
    private List<Task> taskList = new ArrayList<>();
    private int taskId = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                request.getRequestDispatcher("/view/bt8/taskForm.jsp").forward(request, response);
                break;
            case "edit":
                int editId = Integer.parseInt(request.getParameter("id"));
                for (Task t : taskList) {
                    if (t.getId() == editId) {
                        request.setAttribute("task", t);
                        break;
                    }
                }
                request.getRequestDispatcher("/view/bt8/taskForm.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("tasks", taskList);
                request.getRequestDispatcher("/view/bt8/taskList.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                taskList.add(new Task(taskId++, request.getParameter("description"),
                        request.getParameter("dueDate"), false));
                response.sendRedirect("tasks");
                break;
            case "update":
                int updateId = Integer.parseInt(request.getParameter("id"));
                for (Task t : taskList) {
                    if (t.getId() == updateId) {
                        t.setDescription(request.getParameter("description"));
                        t.setDueDate(request.getParameter("dueDate"));
                        t.setCompleted("on".equals(request.getParameter("completed")));
                        break;
                    }
                }
                response.sendRedirect("tasks");
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                taskList.removeIf(t -> t.getId() == deleteId);
                response.sendRedirect("tasks");
                break;
        }
    }
}
