package com.orderservice.app.model;


public class Category {
	
	private int id;

	private String categoryName;

	private String categoryImg;
	
	public Category() {
		
	}

	
	
	public Category(int id, String categoryName, String categoryImg) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryImg = categoryImg;
	}



	public String getCategoryImg() {
		return categoryImg;
	}


	public void setCategoryImg(String categoryImg) {
		this.categoryImg = categoryImg;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
}
