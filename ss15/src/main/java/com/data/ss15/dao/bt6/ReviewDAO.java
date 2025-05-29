package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Review;

import java.util.List;

public interface ReviewDAO {
    List<Review> getAllReviews();
    Review getReviewById(String id);
    boolean insertReview(Review review);
    boolean updateReview(Review review);
    boolean deleteReview(String id);
}



