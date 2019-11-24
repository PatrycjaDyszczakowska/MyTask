package com.credit.app.services;

import com.credit.app.model.Credit;
import com.credit.app.model.JsonCredit;
import com.credit.app.repository.ICreditRepository;
import com.mysql.cj.xdevapi.JsonArray;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService implements ICreditService {

    @Autowired
    private ICreditRepository iCreditRepository;


    @Override
    public List<JsonCredit> getCredits(String customer, String product) {
        List<Credit> credits = iCreditRepository.getCredits();
        List<JsonCredit>jsonCredits = new ArrayList<>();
        JSONArray customerArray = new JSONArray(customer);
        //System.out.println(customerArray.getJSONObject(1));
        JSONArray productArray = new JSONArray(product);
        //System.out.println(productArray.getJSONObject(1));
        for (Credit credit:credits){
            JsonCredit jsonCredit = new JsonCredit();
            jsonCredit.setCreditName(credit.getCreditName());
            jsonCredit.setValue(productArray.getJSONObject(credit.getID()-1).getInt("value"));
            jsonCredit.setProductName(productArray.getJSONObject(credit.getID()-1).getString("productName"));
            jsonCredit.setPesel(customerArray.getJSONObject(credit.getID()-1).getString("pesel"));
            jsonCredit.setSurname(customerArray.getJSONObject(credit.getID()-1).getString("surname"));
            jsonCredit.setFirstName(customerArray.getJSONObject(credit.getID()-1).getString("firstName"));
            jsonCredits.add(jsonCredit);
        }
        return jsonCredits;
    }

    @Override
    public void createCredit(Credit credit) {
        iCreditRepository.createCredit(credit);
        iCreditRepository.getCreditID(credit);
    }
}
