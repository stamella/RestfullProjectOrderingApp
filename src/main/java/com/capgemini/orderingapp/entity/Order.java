package com.capgemini.orderingapp.entity;

import java.time.LocalDate;
import java.util.Set;



import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

 @Document(collection = "orders")
public class Order {

	@Id
	private int orderId;
	private double total;
	private int customerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	private Set<LineItem> items;

	public Order() {
		super();
	}

	public Order(int orderId, double total, int customerId, LocalDate orderDate, Set<LineItem> items) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Set<LineItem> getItems() {
		return items;
	}

	public void setItems(Set<LineItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", total=" + total + ", customerId=" + customerId + ", orderDate="
				+ orderDate + ", items=" + items + "]";
	}
	
}