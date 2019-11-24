package com.credit.app.services;

import com.credit.app.model.Credit;
import com.credit.app.model.JsonCredit;
import com.credit.app.repository.ICreditRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa wywołana przez kontroler do komunikacji z klasą odpowiadającą za
 * pobieranie danych z bazy oraz agregującą dane z usług o producie i kliencie
 */
@Service
public class CreditService implements ICreditService {
    /**
     * Wywołany jest interfejs iCreditRepository
     */
    @Autowired
    private ICreditRepository iCreditRepository;

    /**
     * Metoda pobierająca z klasy CreditRepositowy liste wszystkich kredytów
     * oraz agregująca dane z usług o produktach i klientach
     * @param customer - informacje o wszystkich kliencie
     * @param product - informacje o wszystkich produktach
     * @return Lista informacji o kredycie, produkcie oraz kliencie
     */
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

    /**
     * Metoda wywołująca dodawanie w klasie CreditPrepository nowy kredyt
     * @param credit - informacje o kredycie
     */
    @Override
    public void createCredit(Credit credit) {
        iCreditRepository.createCredit(credit);
        iCreditRepository.getCreditID(credit);
    }
}
