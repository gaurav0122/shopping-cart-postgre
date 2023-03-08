package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Category;
import com.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategoryId(int id);

	List<Product> findByProductName(String productName);

	List<Product> findByProductType(String producttype);

	List<Product> findByMerchantId(int merchantId);

	List<Product> findAllByCategoryId(int id);



	

}
