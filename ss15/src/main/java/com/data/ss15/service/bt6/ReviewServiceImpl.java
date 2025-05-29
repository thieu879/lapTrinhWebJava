package com.data.ss15.service.bt6;

import com.data.ss15.dao.bt6.ReviewDAO;
import com.data.ss15.dao.bt6.ReviewDAOImpl;
import com.data.ss15.model.bt6.Review;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private ReviewDAO reviewDAO = new ReviewDAOImpl();

    @Override
    public List<Review> getAllReviews() {
        return reviewDAO.getAllReviews();
    }

    @Override
    public Review getReviewById(String id) {
        return reviewDAO.getReviewById(id);
    }

    @Override
    public boolean addReview(Review review) {
        return reviewDAO.insertReview(review);
    }

    @Override
    public boolean updateReview(Review review) {
        return reviewDAO.updateReview(review);
    }

    @Override
    public boolean deleteReview(String id) {
        return reviewDAO.deleteReview(id);
    }
}

