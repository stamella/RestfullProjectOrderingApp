package com.capgemini.orderingapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orderingapp.entity.LineItem;
import com.capgemini.orderingapp.entity.Order;
import com.capgemini.orderingapp.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/shopping")
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem item, int customerId) {
		orderService.addLineItem(item, customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/shopping")
	public ResponseEntity<Set<LineItem>> getLineItems(int customerId) {
		Set<LineItem> tempSet = orderService.getLineItems(customerId);
		return new ResponseEntity<Set<LineItem>>(tempSet, HttpStatus.OK);
	}

	@DeleteMapping("/shopping")
	public ResponseEntity<Set<LineItem>> removeLineItem(int customerId, @RequestBody LineItem item) {
		orderService.removeLineItem(item, customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/shopping/submitorder")
	public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.submitOrder(order), HttpStatus.OK);

	}

}