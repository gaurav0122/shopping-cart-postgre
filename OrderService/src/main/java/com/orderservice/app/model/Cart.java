package com.orderservice.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Cart {


    private int cartId;
	
    private double totalPrice;

    private int userId;
    
    private double totalItems;
    
    private List<Items2> items;
    
	
	public Cart() {
        super();


    }
    
	
    public Cart(int cartId, double totalPrice, int userId, double totalItems, List<Items2> items) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.totalItems = totalItems;
		this.items = items;
	}

	public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Items2> getItems() {
		return items;
	}

	public void setItems(List<Items2> items) {
		this.items = items;
	}
	
    public double getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(double totalItems) {
		this.totalItems = totalItems;
	}


	@Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                '}';
    }

   
    
}
