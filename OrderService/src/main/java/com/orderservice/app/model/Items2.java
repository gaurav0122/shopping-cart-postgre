package com.orderservice.app.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


public class Items2 {
	
	private int productId;
	
    private String productName;
    
    private String productImg;
    
	private double price;
    
    private int quantity;


    public Items2( int productId, String productName, String productImg, double price, int quantity) {
		super();
		
		this.productId = productId;
		this.productName = productName;
		this.productImg = productImg;
		this.price = price;
		this.quantity = quantity;
	}

	public Items2() {
		super();
		// TODO Auto-generated constructor stub
	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items2 items = (Items2) o;
        return Double.compare(items.price, price) == 0 && quantity == items.quantity && productName.equals(items.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, quantity);
    }
}
