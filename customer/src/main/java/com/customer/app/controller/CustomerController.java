package com.customer.app.controller;

import com.customer.app.model.Customer;
import com.customer.app.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa kontrolująca zapytania usługi REST Klienta
 */
@Controller
public class CustomerController {
    /**
     * Wywołany jest interfejs iCustomerService
     */
    @Autowired
    private ICustomerService iCustomerService;

    /**
     * Metoda, która jest wyświetlana na początku przy połaczeniu z usługą
     * @return zwraca prosty komunikat hello
     */
    @GetMapping(path = "/")
    public @ResponseBody
    String hello(){
        return "hello Customer what do u need?";
    }

    /**
     * Metoda odpowiadająca za wyświetlenie wszystkich klientów przy wywołaniu GetCustomers
     * @return zwraca Json z danymi
     */
    @GetMapping(path = "/GetCustomers")
    public @ResponseBody Iterable<Customer> getCustomers(){
        return iCustomerService.getCustomers();
    }

    /**
     * Metoda odpowiadająca za stworzenie klientów przy wywołaniu CreateCustomer
     * @param customerJson - komunikacja za pomocą Json
     * @return zwraca komunikat "Done!" przy skończeniu
     */
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
