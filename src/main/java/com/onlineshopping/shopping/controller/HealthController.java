package com.onlineshopping.shopping.controller;

import com.onlineshopping.shopping.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus health() {
        return HttpStatus.OK;
    }
}
