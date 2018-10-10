package com.capgemini.orderingapp.service;

import java.util.List;
import java.util.Set;

import com.capgemini.orderingapp.entity.LineItem;
import com.capgemini.orderingapp.entity.Order;
import com.capgemini.orderingapp.exception.OrderAlreadyRegisteredException;
import com.capgemini.orderingapp.exception.OrderDoesnotExistsException;

public interface OrderService {

	public void addLineItem(LineItem item, int customerId);

	public void removeLineItem(LineItem item, int customerId);

	public Set<LineItem> getLineItems(int customerId);
	
	public Set<Order> getOrders(int customerId) throws OrderDoesnotExistsException;

	public Order getOrder(int orderId) throws OrderDoesnotExistsException;

	public Order submitOrder(Order order);

	public void cancelOrder(int orderId) throws OrderDoesnotExistsException;

	public void deleteOrder(Order order) throws OrderDoesnotExistsException;
}