package com.product.app.repository;

import com.product.app.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getCustomers();
    void createProduct(Product product);
}
