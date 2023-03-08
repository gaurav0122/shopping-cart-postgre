package com.orderservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.app.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
