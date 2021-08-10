package com.onlineshopping.shopping.repository;

import com.onlineshopping.shopping.model.OrderProduct;
import com.onlineshopping.shopping.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
