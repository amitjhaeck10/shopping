package com.onlineshopping.shopping.service;

import com.onlineshopping.shopping.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

    @NotNull
    Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "Order cannot be null") @Valid Order order);

    void update(@NotNull(message = "Order cannot be null") @Valid Order order);
}
