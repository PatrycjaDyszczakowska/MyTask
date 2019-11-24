package com.credit.app.controller;

import com.credit.app.model.Credit;
import com.credit.app.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class CreditController {
    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    protected RestTemplate restTemplate;

    @GetMapping(path = "/")
    public @ResponseBody String hello(){
        return "Hello Credit what do u need?";
    }

    @GetMapping(path = "/GetCredits")
    public @ResponseBody Iterable<Credit> getCredits(){
        return creditRepository.findAll();
    }

    @GetMapping(path = "/getCredit5")
    public @ResponseBody Optional getCredit5(){
        return creditRepository.findById(5);
    }

    @PostMapping(path = "/CreateCredit")
    public @ResponseBody String createCredit (@RequestParam("creditName") String creditName,
                                              @RequestParam("firstName") String firstName,
                                              @RequestParam("surname") String surname,
                                              @RequestParam("pesel") String pesel,
                                              @RequestParam("productName") String productName,
                                              @RequestParam("value") Integer value){
        if (pesel.length() == 11) {
            Credit credit = new Credit();
            credit.setCreditName(creditName);
            creditRepository.save(credit);
            //restTemplate.exchange("http://localhost:8082/CreateProduct?creditId=" + credit.getID() + "&productName=" + productName + "&value=" + value, HttpMethod.POST, null, new ParameterizedTypeReference<String>() {});
            //restTemplate.exchange("http://localhost:8081/CreateCustomer?creditId=" + credit.getID() + "&firstName=" + firstName + "&surname=" + surname + "&pesel=" + pesel, HttpMethod.POST, null, new ParameterizedTypeReference<String>() {});
            restTemplate.exchange("http://product:8082/CreateProduct?creditId=" + credit.getID() + "&productName=" + productName + "&value=" + value, HttpMethod.POST, null, new ParameterizedTypeReference<String>() {});
            restTemplate.exchange("http://customer:8081/CreateCustomer?creditId=" + credit.getID() + "&firstName=" + firstName + "&surname=" + surname + "&pesel=" + pesel, HttpMethod.POST, null, new ParameterizedTypeReference<String>() {});
            return "{\n\"Numer kredytu\": " + credit.getID().toString() + "\n}";
        }else {
            return "Error: Zły pesel";
        }
    }
}
