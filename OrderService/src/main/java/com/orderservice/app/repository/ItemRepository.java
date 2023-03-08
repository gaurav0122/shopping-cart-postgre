package com.orderservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.app.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Integer>{

}
