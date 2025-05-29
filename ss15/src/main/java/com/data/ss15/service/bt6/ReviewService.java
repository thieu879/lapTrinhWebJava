package com.data.ss15.service.bt6;

import com.data.ss15.model.bt6.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(String id);
    boolean addReview(Review review);
    boolean updateReview(Review review);
    boolean deleteReview(String id);
}


