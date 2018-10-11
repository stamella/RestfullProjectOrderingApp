package com.capgemini.orderingapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orderingapp.entity.Order;
import com.capgemini.orderingapp.exception.CustomerDoesnotExistsException;
import com.capgemini.orderingapp.exception.OrderDoesnotExistsException;
import com.capgemini.orderingapp.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	

	@PostMapping("/orders/submitorder")
	public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.submitOrder(order), HttpStatus.OK);
    }
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteOrder(@PathVariable int orderId) throws OrderDoesnotExistsException {
	orderService.deleteOrder(orderId);
	}
	
	@PutMapping("/orders/editorder")
	public ResponseEntity<Order> editOrder(@RequestBody Order order) throws OrderDoesnotExistsException {
		return new ResponseEntity<Order>(orderService.editOrder(order), HttpStatus.OK);
    }
	

	@PutMapping("/orders/{orderId}")
	public ResponseEntity<Order> cancelOrder(@PathVariable int orderId ,@RequestBody Order order) throws OrderDoesnotExistsException {
		return new ResponseEntity<Order>(orderService.cancelOrder(orderId,order), HttpStatus.OK);
    }
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable int orderId) throws OrderDoesnotExistsException {
	     return new ResponseEntity<Order>(orderService.getOrderById(orderId),HttpStatus.OK);
	}
	
	@GetMapping("/customer/orders/{customerId}")
	public ResponseEntity<List<Order>> getOrders(@PathVariable int customerId) {
		return new ResponseEntity<List<Order>>(orderService.getOrderByCustomerId(customerId), HttpStatus.OK);

	}

	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
	}
}