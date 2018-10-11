package com.capgemini.orderingapp.service;

import java.util.List;
import java.util.Set;

import com.capgemini.orderingapp.entity.LineItem;
import com.capgemini.orderingapp.entity.Order;
import com.capgemini.orderingapp.exception.CustomerDoesnotExistsException;
import com.capgemini.orderingapp.exception.OrderAlreadyRegisteredException;
import com.capgemini.orderingapp.exception.OrderDoesnotExistsException;

public interface OrderService {

    public Order submitOrder(Order order);
	
	public Order editOrder(Order order)throws OrderDoesnotExistsException;

	public Order cancelOrder(int orderId,Order order) throws OrderDoesnotExistsException;

	public void deleteOrder(int orderId) throws OrderDoesnotExistsException;
	
	public Order getOrderById(int orderId) throws OrderDoesnotExistsException;
	
	public List<Order> getOrderByCustomerId(int customerId);
	
	public List<Order> getAllOrders();

	
}
	