package com.example.ss5.controller.Bt9;

import com.example.ss5.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/blog")
public class BlogController extends HttpServlet {
    private List<Post> posts;

    public void init() {
        posts = new ArrayList<>();
        posts.add(new Post(1, "Bài viết đầu tiên", "Nội dung bài viết đầu tiên...", "Admin", "2024-05-01"));
        posts.add(new Post(2, "Hướng dẫn Java", "Java cơ bản đến nâng cao...", "Nguyễn Văn A", "2024-05-03"));
        posts.add(new Post(3, "Tìm hiểu JSP", "JSP là gì và dùng như thế nào...", "Trần Thị B", "2024-05-05"));
        getServletContext().setAttribute("posts", posts);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("post".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Post p : posts) {
                if (p.getId() == id) {
                    request.setAttribute("post", p);
                    break;
                }
            }
            request.getRequestDispatcher("/view/bt9/postDetail.jsp").forward(request, response);
        } else {
            request.setAttribute("posts", posts);
            request.getRequestDispatcher("/view/bt9/postList.jsp").forward(request, response);
        }
    }
}
