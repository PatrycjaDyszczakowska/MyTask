package com.customer.app.controller;

import com.customer.app.model.Customer;
import com.customer.app.repository.ICustomerRepository;
import com.customer.app.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(path = "/")
    public @ResponseBody
    String hello(){
        return "hello Customer what do u need?";
    }

    @GetMapping(path = "/GetCustomers")
    public @ResponseBody Iterable<Customer> getCustomers(){
        return iCustomerService.getCustomers();
    }

    @PostMapping(path = "/CreateCustomer")
    public @ResponseBody String createCustomer(@RequestBody Customer customerJson){
        Customer customer = new Customer();
        customer.setCreditID(customerJson.getCreditID());
        customer.setFirstName(customerJson.getFirstName());
        customer.setSurname(customerJson.getSurname());
        customer.setPesel(customerJson.getPesel());
        iCustomerService.createCustomer(customer);
        return "Done!";
    }
}
