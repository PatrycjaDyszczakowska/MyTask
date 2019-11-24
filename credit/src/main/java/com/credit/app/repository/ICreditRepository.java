package com.credit.app.repository;

import com.credit.app.model.Credit;

import java.util.List;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Interfejs do klasy CreditRepository
 */
public interface ICreditRepository {
    List<Credit> getCredits();
    void createCredit(Credit credit);
    void getCreditID(Credit credit);
}
