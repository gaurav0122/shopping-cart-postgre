package com.orderservice.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.orderservice.app.model.Orders;


public interface OrderService {

	//public Order addOrder(Cart cart, Order order);

	public List<Orders> getAllOrder();

	public Orders getOrderById(int orderId);

	public String deleteOrderById(int OrderId);

	public Orders addOrder(int cartId, Orders order);

	public List<Orders> getOrdersByUserId(int userId);

	public Orders cancelOrderByOrderId(int orderId);

	
	
	

}
