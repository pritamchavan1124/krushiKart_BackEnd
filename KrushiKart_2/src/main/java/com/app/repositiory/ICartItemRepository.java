package com.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.CartItem;
import com.app.pojos.Products;
import com.app.pojos.User;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Long>{

	CartItem findByUserAndProduct(User customer, Products product);

//	List<CartItem> findByUser(User customer);
//
//	void deleteByUserAndProduct(Integer id, Long id2);

	

}
