package com.customer.app.services;

import com.customer.app.model.Customer;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Interfejs do klasy CustomerService
 */
public interface ICustomerService {
    Iterable<Customer> getCustomers();
    void createCustomer(Customer customer);
}
