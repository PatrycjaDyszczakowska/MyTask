package com.credit.app.dao;

import com.credit.app.model.Credit;

import java.util.List;

public interface CreditDao {
    List<Credit> GetCredit();
    void CreateCredit(Credit credit);
}
