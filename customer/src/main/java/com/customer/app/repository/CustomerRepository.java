package com.customer.app.repository;

import com.customer.app.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa w której wysyłane są i pobierane z bazy danych informacje o klientach
 */
@Repository
public class CustomerRepository implements ICustomerRepository {
    /**
     * Komunikacja za pomocą JdbcTemplate
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Metoda odpowiadająca za pobieranie wszystkich danych o klientach z bazy
     * @return lista wszystkich klientów
     */
    @Override
    public List<Customer> getCustomers() {
        String SQL = "SELECT * FROM Customer";
        List<Customer> customers = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String,Object> row:rows) {
            Customer customer = new Customer();
            customer.setID((int)row.get("ID"));
            customer.setCreditID((int)row.get("CreditID"));
            customer.setFirstName((String)row.get("FirstName"));
            customer.setSurname((String)row.get("Surname"));
            customer.setPesel((String)row.get("Pesel"));
            customers.add(customer);
        }
        return customers;
    }

    /**
     * Metoda odpowiadająca za dodawanie klienta do bazy
     * @param customer - informacje o dodawanym kliencie do bazy
     */
    @Override
    public void createCustomer(Customer customer) {
        String SQL = "INSERT INTO Customer (CreditID, FirstName, Surname, Pesel) VALUES (?,?,?,?)";
        jdbcTemplate.update(SQL, new Object[]{customer.getCreditID(),customer.getFirstName(),customer.getSurname(),customer.getPesel()});
    }
}
