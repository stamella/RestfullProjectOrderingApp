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
	private String status;

	public Order() {
		super();
	}

	public Order(int orderId, double total, int customerId, LocalDate orderDate, Set<LineItem> items, String status) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.items = items;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", total=" + total + ", customerId=" + customerId + ", orderDate="
				+ orderDate + ", items=" + items + ", status=" + status + "]";
	}

	
	
	
}