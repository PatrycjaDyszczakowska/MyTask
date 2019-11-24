package com.product.app.service;

import com.product.app.model.Product;
import com.product.app.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> getProducts() {
        List<Product> products = iProductRepository.getCustomers();
        return products;
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }
}
