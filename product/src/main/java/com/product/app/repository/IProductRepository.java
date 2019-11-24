package com.product.app.repository;

import com.product.app.model.Product;

import java.util.List;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Interfejs do klasy ProductRepository
 */
public interface IProductRepository {
    List<Product> getCustomers();
    void createProduct(Product product);
}
