package com.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class ReviewAndRating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	
	private double ratings;

	private String reviewTitle;
	
	@Column(length = 10000)
	private String reviewText;
	
	private int productId;
	
	private int userId;
	
	private String userName; 

	
	public ReviewAndRating() {
		super();
	}


	public ReviewAndRating(int reviewId, double ratings, String reviewText, String reviewTitle, int productId,
			int userId, String userName) {
		super();
		this.reviewId = reviewId;
		this.ratings = ratings;
		this.reviewText = reviewText;
		this.reviewTitle = reviewTitle;
		this.productId = productId;
		this.userId = userId;
		this.userName = userName;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public double getRatings() {
		return ratings;
	}


	public void setRatings(double ratings) {
		this.ratings = ratings;
	}


	public String getReviewText() {
		return reviewText;
	}


	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}


	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
