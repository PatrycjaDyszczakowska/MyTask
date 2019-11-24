package com.product.app.repository;

import com.product.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa w której wysyłane są i pobierane z bazy danych informacje o Produktach
 */
@Repository
public class ProductRepository implements IProductRepository {

    /**
     * Komunikacja za pomocą JdbcTemplate
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Metoda odpowiadająca za pobieranie wszystkich danych o produktach z bazy
     * @return lista wszystkich produktów
     */
    @Override
    public List<Product> getCustomers() {
        String SQL = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String,Object> row:rows) {
            Product product = new Product();
            product.setID((int)row.get("ID"));
            product.setCreditID((int)row.get("CreditID"));
            product.setProductName((String) row.get("ProductName"));
            product.setValue((int)row.get("Value"));
            products.add(product);
        }
        return products;
    }

    /**
     * Metoda odpowiadająca za dodawanie produktu do bazy
     * @param product - informacje o dodawanym produkcie do bazy
     */
    @Override
    public void createProduct(Product product) {
        String SQL = "INSERT INTO Product(CreditID, ProductName, Value) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, new Object[]{product.getCreditID(), product.getProductName(),product.getValue()});
    }

    
}
