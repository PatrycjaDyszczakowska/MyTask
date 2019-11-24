package com.credit.app.controller;

import com.credit.app.model.Credit;
import com.credit.app.model.JsonCredit;
import com.credit.app.services.ICreditService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CreditController {
    @Autowired
    private ICreditService iCreditService;

    @Autowired
    protected RestTemplate restTemplate;

    @GetMapping(path = "/")
    public @ResponseBody String hello(){
        return "Hello Credit what do u need?";
    }

    @GetMapping(path = "/GetCredits")
    public @ResponseBody
    List<JsonCredit> getCredits(){
        //ResponseEntity<String> responseProduct = restTemplate.exchange("http://localhost:8082/GetProducts", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        ResponseEntity<String> responseProduct = restTemplate.exchange("http://product:8082/GetProducts", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        //ResponseEntity<String> responseCustomer = restTemplate.exchange("http://localhost:8081/GetCustomers", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        ResponseEntity<String> responseCustomer = restTemplate.exchange("http://customer:8081/GetCustomers", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        return iCreditService.getCredits(responseCustomer.getBody(), responseProduct.getBody());
    }

    @PostMapping(path = "/CreateCredit")
    public @ResponseBody String createCredit (@RequestBody JsonCredit jsonCredit){
        if (jsonCredit.getPesel().length() == 11) {
            Credit credit = new Credit();
            credit.setCreditName(jsonCredit.getCreditName());
            iCreditService.createCredit(credit);

            HttpHeaders httpHeadersCustomer = new HttpHeaders();
            httpHeadersCustomer.set("Content-Type", "application/json");
            JSONObject jsonCustomer = new JSONObject();
            jsonCustomer.put("pesel",jsonCredit.getPesel());
            jsonCustomer.put("firstName",jsonCredit.getFirstName());
            jsonCustomer.put("surname", jsonCredit.getSurname());
            jsonCustomer.put("creditID",credit.getID());
            HttpEntity <String> httpEntityCustomer = new HttpEntity<String>(jsonCustomer.toString(), httpHeadersCustomer);
            //restTemplate.postForObject("http://localhost:8081/CreateCustomer",httpEntityCustomer,String.class);
            restTemplate.postForObject("http://customer:8081/CreateCustomer",httpEntityCustomer,String.class);

            HttpHeaders httpHeadersProduct = new HttpHeaders();
            httpHeadersProduct.set("Content-Type", "application/json");
            JSONObject jsonProduct = new JSONObject();
            jsonProduct.put("productName",jsonCredit.getProductName());
            jsonProduct.put("value",jsonCredit.getValue());
            jsonProduct.put("creditID",credit.getID());
            HttpEntity <String> httpEntityProduct = new HttpEntity<String>(jsonProduct.toString(), httpHeadersProduct);
            //restTemplate.postForObject("http://localhost:8082/CreateProduct",httpEntityProduct,String.class);
            restTemplate.postForObject("http://product:8082/CreateProduct",httpEntityProduct,String.class);
            return "{\n\"Numer kredytu\": " + credit.getID()+ "\n}";
        }else {
            return "Error: Zły pesel";
        }
    }
}
