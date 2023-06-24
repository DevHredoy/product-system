package com.rafiul.productsystem.controller;


import com.rafiul.productsystem.model.Product;
import com.rafiul.productsystem.repository.ProductRepo;
import com.rafiul.productsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String goHome(){
        return "HEY!!, You are at Homepage";
    }
    @GetMapping("/product/all")
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/product/{name}")
    public Optional<Product> findProductByName(@PathVariable String name){
        return productService.findProductByName(name);
    }
    @PostMapping("/product/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }


    @PutMapping("/cars/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int prodId,@RequestBody Product newProd) {
        return ResponseEntity.ok().body(productService.updateProduct(prodId,newProd));

    }



  @DeleteMapping("{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable("id") int prodId){
productService.deleteProduct(prodId);

      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }
}
