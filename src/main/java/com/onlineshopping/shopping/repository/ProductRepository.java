package com.onlineshopping.shopping.repository;

import com.onlineshopping.shopping.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
