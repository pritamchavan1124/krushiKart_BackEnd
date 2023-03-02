package com.app.service.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_Exceptions.UserHandlingException;
import com.app.dto.Userdto;
import com.app.pojos.Address;
import com.app.pojos.CartItem;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderStatus;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.PaymentStatus;
import com.app.pojos.PaymentType;
import com.app.pojos.Products;
import com.app.pojos.User;
import com.app.repositiory.ICartItemRepository;
import com.app.repositiory.IOrderRepositiory;
import com.app.repositiory.IPaymentRepositary;
import com.app.service.user.IUserService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
@Transactional
public class OrderServiceImple implements IOrderServices {

	
	@Autowired
	private IOrderRepositiory orderRepo;
	
	@Autowired
	private IUserService userServices;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ICartItemRepository cartRepo;
	
	@Autowired
	private IPaymentRepositary paymentRepo;
	
	@Override
	public Orders getOrders(Long id) {
	 return orderRepo.findById(id).get();
		
	}
	


		@Override
		public List<Orders> getOrderList(int Userid) {
//			log.info("In order service implimentaion : get list of orders by userID");
			Userdto existUser = userServices.getUserById(Userid);
			return orderRepo.findByUser(mapper.map(existUser, User.class));
		}

		
}
