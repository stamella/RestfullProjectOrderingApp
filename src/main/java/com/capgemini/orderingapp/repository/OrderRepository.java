package com.capgemini.orderingapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.orderingapp.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

		

        @Query("{'customerId': ?0}")
		public List<Order> findByCustomerId(int customerId);

}
