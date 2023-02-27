package com.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CartItem;
import com.app.pojos.Categorys;

public interface CartItemRepositiory extends JpaRepository<CartItem, Long>{

}
