package com.credit.app.services;

import com.credit.app.model.Credit;
import com.credit.app.model.JsonCredit;

import java.util.List;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Interfejs do klasy CreditService
 */
public interface ICreditService {
    List<JsonCredit> getCredits(String customer, String product);
    void createCredit(Credit credit);
}
