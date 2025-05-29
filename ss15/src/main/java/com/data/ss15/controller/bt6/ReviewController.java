package com.data.ss15.controller.bt6;

import com.data.ss15.model.bt6.Review;
import com.data.ss15.service.bt6.ReviewService;
import com.data.ss15.service.bt6.ReviewServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/reviews")
public class ReviewController extends HttpServlet {
    private ReviewService reviewService = new ReviewServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/bt6/review-form.jsp").forward(req, resp);
                break;
            case "edit":
                String id = req.getParameter("id");
                Review review = reviewService.getReviewById(id);
                req.setAttribute("review", review);
                req.getRequestDispatcher("/bt6/review-form.jsp").forward(req, resp);
                break;
            case "delete":
                id = req.getParameter("id");
                reviewService.deleteReview(id);
                resp.sendRedirect("reviews");
                break;
            default:
                List<Review> list = reviewService.getAllReviews();
                req.setAttribute("reviews", list);
                req.getRequestDispatcher("/bt6/review-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idReview = req.getParameter("idReview");
        String idUser = req.getParameter("idUser");
        String idProduct = req.getParameter("idProduct");
        String comment = req.getParameter("comment");
        int rating = Integer.parseInt(req.getParameter("rating"));

        Review review = new Review(idReview, idUser, idProduct, comment, rating);

        String action = req.getParameter("action");
        if ("edit".equals(action)) {
            reviewService.updateReview(review);
        } else {
            reviewService.addReview(review);
        }
        resp.sendRedirect("reviews");
    }
}

