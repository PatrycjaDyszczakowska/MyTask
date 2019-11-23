package com.product.app.controller;

import com.product.app.model.Product;
import com.product.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/")
    public @ResponseBody String hello(){
        return "Hello Product what do u need?";
    }

    @GetMapping(path = "/GetProducts")
    public @ResponseBody Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping(path = "/CreateProduct")
    public @ResponseBody String createProduct(@RequestParam("creditId") Integer creditID,
                                              @RequestParam("productName") String productName,
                                              @RequestParam("value") Integer value){
        Product product = new Product();
        product.setCreditID(creditID);
        product.setProductName(productName);
        product.setValue(value);
        productRepository.save(product);
        return "Done!";
    }
}
