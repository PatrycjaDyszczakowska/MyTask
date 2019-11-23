package com.credit.app.service;

import com.credit.app.dao.CreditDao;
import com.credit.app.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditDao creditDao;

    public List<Credit> GetCredit() {
        List<Credit> credits = creditDao.GetCredit();
        return credits;
    }

    @Override
    public void CreateCredit(Credit credit) {
        creditDao.CreateCredit(credit);
    }
}
