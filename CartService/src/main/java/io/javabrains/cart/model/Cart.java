package io.javabrains.cart.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
	
    private double totalPrice;

    @Column(unique = true)
    private int userId;
    
    private double totalItems;
    
    @OneToMany( cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Items> items;
    
	
	public Cart() {
        super();


    }
    
	
    public Cart(int cartId, double totalPrice, int userId, double totalItems, List<Items> items) {
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

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
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
