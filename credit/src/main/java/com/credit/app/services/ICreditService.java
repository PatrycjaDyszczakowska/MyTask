package com.credit.app.services;

import com.credit.app.model.Credit;
import com.credit.app.model.JsonCredit;

import java.util.List;

public interface ICreditService {
    List<JsonCredit> getCredits(String customer, String product);
    void createCredit(Credit credit);
}
