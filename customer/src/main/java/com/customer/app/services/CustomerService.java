package com.customer.app.services;

import com.customer.app.model.Customer;
import com.customer.app.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa wywołana przez kontroler do komunikacji z klasą odpowiadającą za
 * pobieranie danych z bazy
 */
@Service
public class CustomerService implements ICustomerService {
    /**
     * Wywołany jest interfejs iCustomerRepository
     */
    @Autowired
    private ICustomerRepository iCustomerRepository;

    /**
     * Metoda pobierająca z klasy CustomerRepositowy liste wszystkich klientów
     * @return lista klientów
     */
    @Override
    public Iterable<Customer> getCustomers() {
        List<Customer> customers = iCustomerRepository.getCustomers();
        return customers;
    }

    /**
     * Metoda wywołująca dodawanie w klasie CustomerPrepository nowego klienta
     * @param customer - informacje o kliencie
     */
    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.createCustomer(customer);
    }
}
