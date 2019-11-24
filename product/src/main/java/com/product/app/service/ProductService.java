package com.product.app.service;

import com.product.app.model.Product;
import com.product.app.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa wywołana przez kontroler do komunikacji z klasą odpowiadającą za
 * pobieranie danych z bazy
 */
@Service
public class ProductService implements IProductService {
    /**
     * Wywołany jest interfejs iProductRepository
     */
    @Autowired
    private IProductRepository iProductRepository;

    /**
     * Metoda pobierająca z klasy ProductRepositowy liste wszystkich produktów
     * @return lista produktów
     */
    @Override
    public Iterable<Product> getProducts() {
        List<Product> products = iProductRepository.getCustomers();
        return products;
    }

    /**
     * Metoda wywołująca dodawanie w klasie ProductPrepository nowy produkt
     * @param product - informacje o produkcie
     */
    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }
}
