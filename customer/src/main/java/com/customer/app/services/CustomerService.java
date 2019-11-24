package com.customer.app.services;

import com.customer.app.model.Customer;
import com.customer.app.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Iterable<Customer> getCustomers() {
        List<Customer> customers = iCustomerRepository.getCustomers();
        return customers;
    }

    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.createCustomer(customer);
    }
}
