package com.credit.app.repository;

import com.credit.app.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa w której wysyłane są i pobierane z bazy danych informacje o kredycie
 */
@Repository
public class CreditRepository implements ICreditRepository{
    /**
     * Komunikacja za pomocą JdbcTemplate
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Metoda odpowiadająca za pobieranie wszystkich danych o kredytach z bazy
     * @return lista wszystkich kredytów
     */
    @Override
    public List<Credit> getCredits() {
        String SQL = "SELECT * FROM Credit";
        List<Credit> credits = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String,Object> row:rows) {
            Credit credit = new Credit();
            credit.setID((int)row.get("ID"));
            credit.setCreditName((String)row.get("CreditName"));
            credits.add(credit);
        }
        return credits;
    }

    /**
     * Metoda odpowiadająca za dodawanie kredytu do bazy
     * @param credit - informacje o dodawanym kredycie do bazy
     */
    @Override
    public void createCredit(Credit credit) {
        String SQL = "INSERT INTO Credit (CreditName) VALUES (?)";
        jdbcTemplate.update(SQL, new Object[]{credit.getCreditName()});
    }

    /**
     * Metoda pobierająca ostatni id kredytu z bazy
     * @param credit - informacje o ostatnim dodanym kredycie
     */
    @Override
    public void getCreditID(Credit credit) {
        String SQL = "SELECT MAX(ID) FROM  Credit";
        Integer creditID = jdbcTemplate.queryForObject(SQL,Integer.class);
        credit.setID(creditID);
    }


}
