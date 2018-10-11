package com.capgemini.orderingapp.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.orderingapp.entity.LineItem;
import com.capgemini.orderingapp.entity.Order;
import com.capgemini.orderingapp.exception.CustomerDoesnotExistsException;
import com.capgemini.orderingapp.exception.OrderDoesnotExistsException;
import com.capgemini.orderingapp.repository.OrderRepository;
import com.capgemini.orderingapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	private HashMap<Integer, Set<LineItem>> itemCart = new HashMap<>();

	

	@Override
	public List<Order> getAllOrders()  {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(int orderId) throws OrderDoesnotExistsException {
		Optional<Order> optional = orderRepository.findById(orderId);
		if(optional.isPresent())
			return optional.get();
		throw new OrderDoesnotExistsException("Order Not Found!!");
	}
	
	

	@Override
	public Order submitOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order cancelOrder(int orderId,Order order) throws OrderDoesnotExistsException {
		Optional<Order> optional = orderRepository.findById(orderId);
		if (optional.isPresent()) {
			optional.get().setStatus("Cancelled");
		return orderRepository.save(optional.get());
			
		}
		throw new OrderDoesnotExistsException("Cancelled failed!! Order not found with id ");

	}

	@Override
	public void deleteOrder(int orderId) throws OrderDoesnotExistsException {
		Optional<Order> Optional = orderRepository.findById(orderId);
		if (Optional.isPresent()) {
		orderRepository.deleteById(orderId);
			return;
		}
		throw new OrderDoesnotExistsException("Delete failed!! Order not found with id ");
	}

	@Override
	public Order editOrder(Order order) throws OrderDoesnotExistsException {
      Optional<Order> tempOrder = orderRepository.findById(order.getOrderId());
	  if(tempOrder.isPresent())
		  return orderRepository.save(order);
	  throw new OrderDoesnotExistsException("OrderId Not Found");
      
	}

	@Override
	public List<Order> getOrderByCustomerId(int customerId) {
		return orderRepository.findByCustomerId(customerId);
	}
	
	
}