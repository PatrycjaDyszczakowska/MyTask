package com.product.app.controller;

import com.product.app.model.Product;
import com.product.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(path = "/")
    public @ResponseBody String hello(){
        return "Hello Product what do u need?";
    }

    @GetMapping(path = "/GetProducts")
    public @ResponseBody Iterable<Product> getProducts(){
        return iProductService.getProducts();
    }

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
