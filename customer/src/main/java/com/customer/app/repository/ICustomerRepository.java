package com.customer.app.repository;

import com.customer.app.model.Customer;

import java.util.List;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Interfejs do klasy CustomerRepository
 */
public interface ICustomerRepository {
    List<Customer> getCustomers();
    void createCustomer(Customer customer);
}
