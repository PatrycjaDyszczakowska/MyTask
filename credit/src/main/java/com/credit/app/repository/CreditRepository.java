package com.credit.app.repository;

import com.credit.app.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CreditRepository implements ICreditRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    @Override
    public void createCredit(Credit credit) {
        String SQL = "INSERT INTO Credit (CreditName) VALUES (?)";
        jdbcTemplate.update(SQL, new Object[]{credit.getCreditName()});
    }

    @Override
    public void getCreditID(Credit credit) {
        String SQL = "SELECT MAX(ID) FROM  Credit";
        Integer creditID = jdbcTemplate.queryForObject(SQL,Integer.class);
        credit.setID(creditID);
    }


}
