package com.rafiul.productsystem.service.impl;

import com.rafiul.productsystem.model.Product;
import com.rafiul.productsystem.repository.ProductRepo;
import com.rafiul.productsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepo.findProductByName(name);
    }

    @Override
    public String saveProduct(Product product) {
        Product savePoduct = productRepo.save(product);
        if (savePoduct != null && savePoduct.getName() != "") {
            return "PRODUCT WAS SUCCESSFULLY SAVED";
        }
        return "PLEASE TRY AGAIN< PRODUCT NOT SAVED";
    }

    @Override
    public Product deleteProduct(int ProdId) {
        Optional<Product> retrievedProd=productRepo.findById(ProdId);
                if(retrievedProd==null)
                    try{throw new Exception("product not found");}
                catch(Exception e)
                {e.printStackTrace();}

                productRepo.deleteById(ProdId);
                return retrievedProd.get();
    }

    @Override
    public Product updateProduct(int id, Product prod) {
        Optional<Product> retrievedProd=productRepo.findById(id);
        if(retrievedProd==null)
            try {
                throw new Exception("product not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        productRepo.save(prod);
        return productRepo.findById(id).get();

    }


}
