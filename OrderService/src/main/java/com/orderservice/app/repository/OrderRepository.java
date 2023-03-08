package com.orderservice.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.app.model.Orders;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {

	List<Orders> findByCustomerId(int customerId);

	
}
