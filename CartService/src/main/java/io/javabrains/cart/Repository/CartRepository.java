package io.javabrains.cart.Repository;

import io.javabrains.cart.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	
    List<Cart> findByCartId(int cartId);

	Cart findByUserId(int userId);

	

}
