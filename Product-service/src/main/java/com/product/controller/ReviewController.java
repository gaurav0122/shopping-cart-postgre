package com.product.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.product.model.ReviewAndRating;
import com.product.model.UserProfile;
import com.product.repository.RatingReviewRepository;

@RestController
public class ReviewController {

	@Autowired
	private RatingReviewRepository ratingReviewRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getallreview")
	public List<ReviewAndRating> getReview() {
		
		return ratingReviewRepository.findAll();
	}
	
	@GetMapping("/getreview/{pid}")
	public List<ReviewAndRating> getReviewByProductId(@PathVariable("pid") int productId) {
		
		List<ReviewAndRating> ratings = ratingReviewRepository.findByProductId(productId);
		Collections.reverse(ratings);
		return ratings;
	}
	
	@PostMapping("/postreview/{pid}/{uid}")
	public ReviewAndRating postReviewByUser(@RequestBody ReviewAndRating review,
											@PathVariable("pid") int productId,
											@PathVariable("uid") int userId) {
		review.setProductId(productId);
		review.setUserId(userId);
		UserProfile profile = restTemplate.getForObject("http://profile-service/user/user1/"+userId,
				UserProfile.class);
		review.setUserName(profile.getFullName());
		return ratingReviewRepository.save(review);
		
	}
	
	@PostMapping("/postreview/{pid}")
	public String postReviewList(@RequestBody List<ReviewAndRating> review,
												@PathVariable("pid")int pid) {
		for(ReviewAndRating r :review) {
			r.setProductId(pid);
			ratingReviewRepository.save(r);
		}
		return "posted successfully";
		
	}
	

}
