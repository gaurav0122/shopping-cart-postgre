package com.orderservice.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.app.model.Orders;
import com.orderservice.app.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
//@CrossOrigin("http://localhost:4200/")
public class OrderController  {

	@Autowired
	private OrderService orderService;

	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	// Post order
	@ApiOperation("add order method")
	@PostMapping("/order/{cartId}")
	public Orders addOrder(@PathVariable("cartId") int cartId,@RequestBody Orders order) {
		logger.trace("add order method accessed");
		return orderService.addOrder(cartId, order);		
	}

	// get all Order
	@ApiOperation("get all order method")
	@GetMapping("/allorder")
	public List<Orders> getAllOrder() {
		logger.trace("get all order method accessed");
		List<Orders> OrderList = orderService.getAllOrder();

		return OrderList;
	}

	// get Order by OrderId
	@ApiOperation("get order by Id method")
	@GetMapping("/allorder/{orderId}")
	public Orders getOrderById(@PathVariable("orderId") int orderId) {
		logger.trace("get order by Id method accessed");
		Orders order = orderService.getOrderById(orderId);
		return order;
	}

  	//Delete Order By id
	@ApiOperation("Delete order by orderId")
	@DeleteMapping("/allorder/{orderId}")
	public String deleteOrderById(@PathVariable("OrderId") int orderId) {
		logger.trace("Delete order by orderId method accessed");
		return orderService.deleteOrderById(orderId);
	}
	
	// get All Order by userID
	@ApiOperation("get all orders by user Id method")
	@GetMapping("/allorder/byuser/{userId}")
	public List<Orders> getOrderByUserId(@PathVariable("userId") int userId) {
		logger.trace("get order by Id method accessed");
		return orderService.getOrdersByUserId(userId);
		
	}
	
	//cancel order by order Id
	@ApiOperation("cancel order by order Id method")
	@PutMapping("/allorder/cancelorder/{orderId}")
	public Orders cancelOrderByOrderId(@PathVariable("orderId") int orderId) {
		logger.trace("cancel order by order Id method");
		return orderService.cancelOrderByOrderId(orderId);
		
	}
	
}
