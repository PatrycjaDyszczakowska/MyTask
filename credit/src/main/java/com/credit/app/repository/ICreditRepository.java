package com.credit.app.repository;

import com.credit.app.model.Credit;

import java.util.List;

public interface ICreditRepository {
    List<Credit> getCredits();
    void createCredit(Credit credit);
    void getCreditID(Credit credit);
}
