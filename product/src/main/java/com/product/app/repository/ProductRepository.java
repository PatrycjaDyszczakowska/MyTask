package com.product.app.repository;

import com.product.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    @Override
    public void createProduct(Product product) {
        String SQL = "INSERT INTO Product(CreditID, ProductName, Value) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, new Object[]{product.getCreditID(), product.getProductName(),product.getValue()});
    }

    
}
