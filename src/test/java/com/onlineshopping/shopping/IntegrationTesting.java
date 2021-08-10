package com.onlineshopping.shopping;

import com.onlineshopping.shopping.controller.OrderController;
import com.onlineshopping.shopping.controller.ProductController;
import com.onlineshopping.shopping.dto.OrderProductDto;
import com.onlineshopping.shopping.model.Order;
import com.onlineshopping.shopping.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = { ShoppingApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTesting {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private ProductController productController;

    @Autowired
    private OrderController orderController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(productController).isNotNull();
        Assertions.assertThat(orderController).isNotNull();
    }

    @Test
    public void givenGetProductsApiCall_whenProductListRetrieved_thenSizeMatchAndListContainsProductNames() {
        ResponseEntity<Iterable<Product>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/products",
                HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Product>>() {});
        Iterable<Product> products = responseEntity.getBody();
        Assertions
                .assertThat(products)
                .hasSize(2);

        assertThat(products, hasItem(hasProperty("name", is("apple"))));
        assertThat(products, hasItem(hasProperty("name", is("orange"))));
    }

    @Test
    public void givenGetOrdersApiCall_whenProductListRetrieved_thenSizeMatchAndListContainsProductNames() {
        ResponseEntity<Iterable<Order>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/orders",
                                                                 HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Order>>() {});

        Iterable<Order> orders = responseEntity.getBody();
        Assertions.assertThat(orders).hasSize(0);
    }

    @Test
    public void givenPostOrder_whenBodyRequestMatcherJson_thenResponseContainsEqualObjectProperties() {
        final ResponseEntity<Order> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/orders",prepareOrderForm(), Order.class);
        Order order = postResponse.getBody();
        Assertions.assertThat(postResponse.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(2))));
    }

    private OrderController.OrderForm prepareOrderForm() {
        OrderController.OrderForm orderForm = new OrderController.OrderForm();
        OrderProductDto productDto = new OrderProductDto();
        productDto.setProduct(new Product(1L, "apple", 0.60));
        productDto.setQuantity(2);
        orderForm.setProductOrders(Collections.singletonList(productDto));

        return orderForm;
    }
}
