package com.product.app.controller;

import com.product.app.model.Product;
import com.product.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa kontrolująca zapytania usługi REST Produktów
 */
@Controller
public class ProductController {
    /**
     * Wywołany jest interfejs iProductService
     */
    @Autowired
    private IProductService iProductService;

    /**
     * Metoda, która jest wyświetlana na początku przy połaczeniu z usługą
     * @return zwraca prosty komunikat hello
     */
    @GetMapping(path = "/")
    public @ResponseBody String hello(){
        return "Hello Product what do you need?";
    }

    /**
     * Metoda odpowiadająca za wyświetlenie wszystkich produktów przy wywołaniu GetProducts
     * @return zwraca Json z danymi
     */
    @GetMapping(path = "/GetProducts")
    public @ResponseBody Iterable<Product> getProducts(){
        return iProductService.getProducts();
    }

    /**
     * Metoda odpowiadająca za stworzenie produktów przy wywołaniu CreateProduct
     * @param productJson - komunikacja za pomocą Json
     * @return zwraca komunikat "Done!" przy skończeniu
     */
    @PostMapping(path = "/CreateProduct")
    public @ResponseBody String createProduct(@RequestBody Product productJson){
        Product product = new Product();
        product.setCreditID(productJson.getCreditID());
        product.setProductName(productJson.getProductName());
        product.setValue(productJson.getValue());
        iProductService.createProduct(product);
        return "Done!";
    }
}
