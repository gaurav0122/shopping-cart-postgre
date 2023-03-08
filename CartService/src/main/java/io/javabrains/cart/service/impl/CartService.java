package io.javabrains.cart.service.impl;

import io.javabrains.cart.model.Cart;
import io.javabrains.cart.model.Items;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;



public interface CartService {

    public Cart getCartById(int cartId);
    
    public Cart updateCart(Cart cart,int cartId);
    
    public List<Cart> getAllCarts();
    
    public double CartTotal(int cartId);
    
    public Cart addCart(Cart cart, int userId);
    
	public Cart addItemInCart(int userId, int productId);
	
	public Cart removeProduct(int cartId, int productId);
	
	public Cart addQuantityOfProduct(int cartId, int productId);
	
	public Cart subQuantityOfProduct(int cartId, int productId);
	
	public Cart getCartByuserId(int userId);
	
	public Cart removeAllItemInCart(int cartId);
}
