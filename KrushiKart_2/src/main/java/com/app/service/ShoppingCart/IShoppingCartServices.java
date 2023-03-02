package com.app.service.ShoppingCart;

import com.app.custom_Exceptions.ShoppingCartException;

public interface IShoppingCartServices {

	void deleteByUser(Integer id);

	Long addProduct(Long productId, Long quantity, Long customerId) throws ShoppingCartException;

}
