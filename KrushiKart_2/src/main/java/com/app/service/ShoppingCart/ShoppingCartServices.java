package com.app.service.ShoppingCart;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_Exceptions.ShoppingCartException;
import com.app.custom_Exceptions.UserHandlingException;
import com.app.pojos.CartItem;
import com.app.pojos.Products;
import com.app.pojos.User;
import com.app.repositiory.ICartItemRepository;
import com.app.repositiory.ProductRepository;
import com.app.repositiory.UserRepositiory;
import com.app.service.ProdServiceInterface;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ShoppingCartServices implements IShoppingCartServices {
	
	@Autowired
	private UserRepositiory userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private ProdServiceInterface prodService;
	
	@Autowired
	private ICartItemRepository cartRepo;

	@Override
	public Long addProduct(Long productId, Long quantity, Long customerId) throws ShoppingCartException {
		Optional<User> OptionalCustomer = userRepo.findById(customerId);
		User customer = new User();
		if (OptionalCustomer != null) {
			customer = mapper.map(OptionalCustomer, User.class);
		} else {
			throw new UserHandlingException("NO cart details are found for given customer id");
		}
//		log.info("In Shopping cart service : Add product to cart method");
		Long updatedQuantity = quantity;
		Products product = mapper.map(prodService.getProductById(productId), Products.class);
//		log.info("Product to add in cart" + product);
		CartItem cartItem = cartRepo.findByUserAndProduct(customer, product);

		if (cartItem != null) {
			updatedQuantity = cartItem.getQuantity() + quantity;
			if (updatedQuantity < 0) {
				throw new UserHandlingException("Invalid quanity");
			}
			if (updatedQuantity > 5) {
				throw new ShoppingCartException("Could not add more " + quantity + " item(s)"
						+ " because there's already " + cartItem.getQuantity() + " item(s) "
						+ "in your shopping cart. Maximum allowed quantity is 5.");
			}
		} else {
			cartItem = new CartItem();
			cartItem.setUser(customer);
			cartItem.setProduct(product);
		}

		cartItem.setQuantity(updatedQuantity);

		cartRepo.save(cartItem);

		return updatedQuantity;
		
	}

	@Override
	public void deleteByUser(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
