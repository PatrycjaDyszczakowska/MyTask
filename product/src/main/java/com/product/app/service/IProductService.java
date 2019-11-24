package com.product.app.service;

import com.product.app.model.Product;

public interface IProductService {
    Iterable<Product> getProducts();
    void createProduct(Product product);
}
