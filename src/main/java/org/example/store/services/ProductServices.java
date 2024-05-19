package org.example.store.services;

import org.example.store.model.Product;
import org.example.store.enums.StoreType;
import org.example.store.enums.ProductType;
import org.example.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }
    public Product getProductById(long id) {
        return productRepository.findById(id);
    }
    public List<Product> getAllProducts(StoreType storeType, int storeId, ProductType productType) {
        return productRepository.findAll();
    }
}















