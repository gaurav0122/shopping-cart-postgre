package com.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.model.Category;
import com.product.model.Product;
import com.product.model.UserProfile;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CategoryService categoryService;
	
	//add product 
	public Product addProduct(Product product, int merchantId) {
		
		Category category = categoryService.getByCategoryName(product.getCategory().getCategoryName());
		if(category == null) {
			Category categoryNew = new Category();
			categoryNew.setCategoryName(product.getCategory().getCategoryName());
			categoryNew.setCategoryImg(product.getCategory().getCategoryImg());
			category=  categoryService.addCategory(categoryNew);
		}
		product.setCategory(category);
		
		
			UserProfile profile = restTemplate.getForObject("http://profile-service/user/user1/"+merchantId, 
									UserProfile.class);
			
			
			if(profile.getRole().equalsIgnoreCase("Merchant") ) {
				product.setMerchantId(merchantId);
				product.setMerchantName(profile.getFullName());
				return productRepository.save(product);
			}
			
		
		
		return product;
		
	}
	
	//get all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	//get product by id
	public Product getProductById(int productid) {
		Optional<Product> productOptional=	productRepository.findById(productid);
		return productOptional.get();
	}
	
	
	//delete product by id
	public String deleteProductById(int productid) {
		productRepository.deleteById(productid);
		return "Deleted Succesfully";
	}
	
	//Update Product 
	public Product updateProducts(Product product, int productId) {
		
		Product productDb = productRepository.findById(productId).get();
		
		if(product.getProductType() !=null) {
			productDb.setProducttype(product.getProductType());
		}
		if(product.getProductName() !=null) {
			productDb.setProductName(product.getProductName());
		}
		if(product.getCategory() !=null) {
			productDb.setCategory(product.getCategory());
		}
		
		if(product.getImage() !=null) {
			productDb.setImage(product.getImage());
		}
		
		if(product.getPrice() != 0) {
			productDb.setPrice(product.getPrice());
		}
		
		if(product.getDescription() !=null) {
			productDb.setDescription(product.getDescription());
			
		}
		
		if(product.getSpecification() !=null) {
			productDb.setSpecification(product.getSpecification());
			
		}
		
		return productRepository.save(product);
		
		
	}
	
	//get Product By category
	public List<Product> getProductByCategory(String categoryName){
		//System.out.println(categoryService.getByCategoryName(category).getId());
		
		return productRepository.findAllByCategoryId(categoryService.getByCategoryName(categoryName).getId());
	}
	
	//get Product By Name
	public List<Product> getProductByName( String productName){
		return productRepository.findByProductName(productName);
	}
	
	//get Product By Type 
	public List<Product> getProductByType(String producttype){
		return productRepository.findByProductType(producttype);
	}

	@Override
	public List<Product> getProductByMerchantId(int merchantId) {
		
		return productRepository.findByMerchantId(merchantId);
	}

	@Override
	public List<String> getProductTypeByCategoryId(int categoryId) {
		List<Product> listOfProduct = productRepository.findByCategoryId(categoryId); 
		// listOfProduct.forEach(p-> System.out.println(p));
		return listOfProduct.stream().map(p-> p.getProductType()).distinct().collect(Collectors.toList());
	}

	@Override
	public List<Product> getProductsBySearch(String searchkey) {
		System.out.println(searchkey);
		List<Product> listOfProduct = productRepository.findAll();
		List<Product> listOfProduct1 = listOfProduct.parallelStream().filter(p->
			p.getProductName().contains(searchkey)|| p.getProductType().contains(searchkey)
							|| p.getCategory().getCategoryName().contains(searchkey))
		.collect(Collectors.toList());
		
		return listOfProduct1;
	}

	@Override
	public String addAllProducts(List<Product> list, int merchantId) {
		try {
			for(Product product:list) {
				Category category = categoryService.getByCategoryName(product.getCategory().getCategoryName());
				if(category == null) {
					Category categoryNew = new Category();
					categoryNew.setCategoryName(product.getCategory().getCategoryName());
					categoryNew.setCategoryImg(product.getCategory().getCategoryImg());
					category=  categoryService.addCategory(categoryNew);
				}
				product.setCategory(category);
				
				
					UserProfile profile = restTemplate.getForObject("http://profile-service/user/user1/"+merchantId, 
											UserProfile.class);
					
					
					if(profile.getRole().equalsIgnoreCase("Merchant") ) {
						product.setMerchantId(merchantId);
						product.setMerchantName(profile.getFullName());
						productRepository.save(product);
					}
			}
			
			return "Added successfully";
		} catch (Exception e) {
			
		}
		
		
		return "error occured";
	}
	

		
	}
	
	
	


