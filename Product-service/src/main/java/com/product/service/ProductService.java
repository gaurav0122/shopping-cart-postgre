package com.product.service;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;


public interface ProductService {
	
	public Product addProduct(Product product, int merchantId);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int productid);
	
	public List<Product> getProductByType(String producttype);
	
	public List<Product> getProductByName( String productName);
	
	public List<Product> getProductByCategory( String category);
	
	public Product updateProducts(Product product,int productId);
	
	public String deleteProductById(int productid);
	
	public List<Product> getProductByMerchantId(int merchantId);

	public List<String> getProductTypeByCategoryId(int categoryId);

	public List<Product> getProductsBySearch(String searchkey);

	public String addAllProducts(List<Product> list, int merchatId);

}
