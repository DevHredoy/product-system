package com.rafiul.productsystem;

import com.rafiul.productsystem.model.Product;
import com.rafiul.productsystem.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// In this branch we have tried populate data in real database from main method
 /*modified:   src/main/java/com/rafiul/productsystem/ProductSystemApplication.java
		 modified:   src/main/java/com/rafiul/productsystem/model/Product.java*/

@SpringBootApplication
@RequiredArgsConstructor
public class ProductSystemApplication implements CommandLineRunner {
	private final ProductRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(ProductSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		repo.save(Product.builder().name("sample product").build());
	}
}
