package com.onlineshopping.shopping.repository;

import com.onlineshopping.shopping.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
