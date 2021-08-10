package com.onlineshopping.shopping;

import com.onlineshopping.shopping.model.Product;
import com.onlineshopping.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingApplication {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ProductRepository repository) {
		return (ApplicationArguments args) ->  dataSetup(repository);
	}

	public void dataSetup(ProductRepository repository){
		productRepository.save(new Product(1L,"apple",0.60));
		productRepository.save(new Product(2L,"orange",0.25));
	}
}
