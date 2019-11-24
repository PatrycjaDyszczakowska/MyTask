package com.customer.app.repository;

import com.customer.app.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomers();
    void createCustomer(Customer customer);
}
