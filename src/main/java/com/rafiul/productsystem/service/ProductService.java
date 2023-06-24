package com.rafiul.productsystem.service;

import com.rafiul.productsystem.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> findProductByName(String name);
    String saveProduct(Product product);

    Product deleteProduct(int ProdId);

    Product updateProduct(int id,Product prod);
}
