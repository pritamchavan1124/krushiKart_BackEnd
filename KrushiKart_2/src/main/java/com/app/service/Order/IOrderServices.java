package com.app.service.Order;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Orders;
import com.app.pojos.PaymentType;
import com.razorpay.RazorpayException;

public interface IOrderServices {

	Orders getOrders(Long id);

	List<Orders> getOrderList(int id);

}
