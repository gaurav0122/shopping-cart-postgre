package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.ReviewAndRating;

public interface RatingReviewRepository extends JpaRepository<ReviewAndRating, Integer>{

	List<ReviewAndRating> findByProductId(int productId);

}
