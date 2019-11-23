package com.customer.app.controller;

import com.customer.app.model.Customer;
import com.customer.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/")
    public @ResponseBody String hello(){
        return "hello Customer what do u need?";
    }

    @GetMapping(path = "/GetCustomers")
    public @ResponseBody Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping(path = "/CreateCustomer")
    public @ResponseBody String createCustomer(@RequestParam("creditId") Integer creditID,
                                               @RequestParam("firstName") String firstName,
                                               @RequestParam("surname") String surname,
                                               @RequestParam("pesel") String pesel){
        Customer customer = new Customer();
        customer.setCreditID(creditID);
        customer.setFirstName(firstName);
        customer.setSurname(surname);
        customer.setPesel(pesel);
        customerRepository.save(customer);
        return "Done!";
    }
}
