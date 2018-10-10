package com.capgemini.orderingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.orderingapp.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

}
