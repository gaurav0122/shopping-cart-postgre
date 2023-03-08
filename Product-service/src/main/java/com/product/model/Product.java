package com.product.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;
	
	private String productType;
	
	private String productName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	@ElementCollection
	private List<String> image;	

	private double price;
	
	
	@Column(length = 15000)
	private String description;  
	
	@ElementCollection
	private Map<String, String> specification;  

	private int merchantId;  

	private String merchantName;

	public Product() {
		
	}
	

	public Product(int productid, String productType, String productName, Category category, List<String> image,
			double price, String description, Map<String, String> specification, int merchantId,
			String merchantName) {
		super();
		this.productid = productid;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
		this.merchantId = merchantId;
		this.merchantName = merchantName;
	}


	public int getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public String getProductType() {
		return productType;
	}


	public void setProducttype(String productType) {
		this.productType = productType;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<String> getImage() {
		return image;
	}


	public void setImage(List<String> image) {
		this.image = image;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Map<String, String> getSpecification() {
		return specification;
	}


	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}


	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}


}
