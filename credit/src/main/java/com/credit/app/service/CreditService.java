package com.credit.app.service;

import com.credit.app.model.Credit;

import java.util.List;

public interface CreditService {
    List<Credit> GetCredit();
    void CreateCredit(Credit credit);
}
