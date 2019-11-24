package com.product.app.service;

import com.product.app.model.Product;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Interfejs do klasy ProductService
 */
public interface IProductService {
    Iterable<Product> getProducts();
    void createProduct(Product product);
}
