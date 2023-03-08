package com.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String categoryName;

	@Column(length = 10000)
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
