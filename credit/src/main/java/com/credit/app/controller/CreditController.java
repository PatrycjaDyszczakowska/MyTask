package com.credit.app.controller;

import com.credit.app.model.Credit;
import com.credit.app.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditController {

    @Autowired
    CreditService creditService;

    @RequestMapping("/")
    public String hello(){
        return "Hello Credit";
    }

    @RequestMapping(value = "/GetCredit", method = RequestMethod.GET)
    public List<Credit> getCredit(){
        return creditService.GetCredit();
    }
}
