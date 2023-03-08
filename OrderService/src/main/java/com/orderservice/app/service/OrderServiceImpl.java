package com.orderservice.app.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.app.model.Cart;
import com.orderservice.app.model.Items;
import com.orderservice.app.model.Items2;
import com.orderservice.app.model.Orders;
import com.orderservice.app.model.UserProfile;
import com.orderservice.app.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	
	// add Order
	public Orders addOrder(int cartId,Orders order) {
		//EmailService emailService = new EmailService();
		Cart cart = restTemplate.getForObject("http://cart-service/cart/cart/"+cartId, Cart.class);
		
		int userId = cart.getUserId();
		
		
		UserProfile profile = restTemplate.getForObject("http://profile-service/user/user1/"+userId,
				UserProfile.class);
		
		List<Items2> list = cart.getItems();
		List<Items> items = list.stream().map(i->{
			Items item = new Items();
			item.setPrice(i.getPrice());
			item.setProductId(i.getProductId());
			item.setProductImg(i.getProductImg());
			item.setProductName(i.getProductName());
			item.setQuantity(i.getQuantity());
			return item;
		}).collect(Collectors.toList());
		if(list!=null)
			order.setItems(items);
		order.setAddress(profile.getAddress());
		order.setAmountPaid(cart.getTotalPrice());
		order.setCustomerId(userId);
		order.setOrderDate(LocalDate.now());
		
		order.setOrderStatus("Order Placed");
		
		return orderRepo.save(order);
	}

	// get all Order
	public List<Orders> getAllOrder() {
		return orderRepo.findAll();
	}

	// get Order by id
	public Orders getOrderById(int orderid) {
		Optional<Orders> orderOptional = orderRepo.findById(orderid);
		return orderOptional.get();
	}

	// delete Order by id
	public String deleteOrderById(int orderid) {
		orderRepo.deleteById(orderid);
		return "Order Deleted  or Cancled Succesfully";
	}

	// get order by customer ID
	public List<Orders> getOrdersByUserId(int CustomerId) {
		List<Orders> orders = orderRepo.findByCustomerId(CustomerId);
		Collections.reverse(orders);
		return orders;

	}

	@Override
	public Orders cancelOrderByOrderId(int orderId) {
		Orders order = orderRepo.findById(orderId).get();
		order.setOrderStatus("Cancelled");
		return orderRepo.save(order);
	}

	
	
	
	
	// online payment (using cart )

	// payment Order (using cart )

}

class sortItems implements Comparator<LocalDate> {
	
    public int compare(LocalDate a, LocalDate b)
    {
        // Returning the value after comparing the objects
        // this will sort the data in Ascending order
        return a.compareTo(b);
    }
}