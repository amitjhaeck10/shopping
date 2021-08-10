package com.onlineshopping.shopping.controller;


import com.onlineshopping.shopping.model.Order;
import com.onlineshopping.shopping.model.Product;
import com.onlineshopping.shopping.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        product = this.productService.save(product);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/products/{id}")
                .buildAndExpand(product.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<Product>(product, headers, HttpStatus.CREATED);
    }

}
