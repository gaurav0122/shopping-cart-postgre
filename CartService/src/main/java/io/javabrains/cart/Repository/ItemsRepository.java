package io.javabrains.cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.cart.model.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
