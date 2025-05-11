package com.naboo.primera_fase.service;

import java.util.List;

import com.naboo.primera_fase.entity.Product;
import com.naboo.primera_fase.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product); 
    }

    @Override
    public Product updateProduct(Integer id, Product newProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    
}
