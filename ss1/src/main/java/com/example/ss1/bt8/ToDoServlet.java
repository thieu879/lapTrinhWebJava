package com.example.ss1.bt8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ToDoServlet", value = "/todo")
public class ToDoServlet extends HttpServlet {
    private static final List<Task> taskList = new ArrayList<>();
    private static int taskIdCounter = 1;

    @Override
    public void init() throws ServletException {
        taskList.add(new Task(taskIdCounter++, "Design Website", "Completed"));
        taskList.add(new Task(taskIdCounter++, "Develop Application", "Doing"));
        taskList.add(new Task(taskIdCounter++, "Test Software", "Completed"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("taskList", taskList);
        request.getRequestDispatcher("/WEB-INF/todoList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String jobName = request.getParameter("jobName");
            if (jobName != null && !jobName.trim().isEmpty()) {
                taskList.add(new Task(taskIdCounter++, jobName, "Doing"));
            }
        } else if ("changeStatus".equals(action)) {
            int taskId = Integer.parseInt(request.getParameter("taskId"));
            for (Task task : taskList) {
                if (task.getId() == taskId) {
                    task.setStatus(task.getStatus().equals("Completed") ? "Doing" : "Completed");
                    break;
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/todo");
    }
}
