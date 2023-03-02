package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_Exceptions.ShoppingCartException;
import com.app.dto.AddProductDto;
import com.app.pojos.Categorys;
import com.app.service.ShoppingCart.IShoppingCartServices;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cart")
@Slf4j
public class ShoppingCartController {
	//dependency injection
	@Autowired
	private IShoppingCartServices shoppingCartService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addProductInCart(@RequestBody AddProductDto prodDto) throws ShoppingCartException {
		log.info("In Shopping Cart controller : addProductInCart");
		shoppingCartService.addProduct(prodDto.getProductId(), prodDto.getQuantity(), prodDto.getCustomerId());
		return new ResponseEntity<>("Added sucessfully", HttpStatus.OK);

	}

}
