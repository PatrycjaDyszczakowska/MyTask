package com.customer.app.services;

import com.customer.app.model.Customer;

public interface ICustomerService {
    Iterable<Customer> getCustomers();
    void createCustomer(Customer customer);
}
