package com.credit.app.model;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa zawierająca informacje o produkcie, kliencie oraz kredycie
 */
public class JsonCredit {
    private String CreditName;
    private String FirstName;
    private String Surname;
    private String Pesel;
    private String ProductName;
    private Integer Value;

    public JsonCredit() {
    }

    public JsonCredit(String creditName, String firstName, String surname, String pesel, String productName, Integer value) {
        CreditName = creditName;
        FirstName = firstName;
        Surname = surname;
        Pesel = pesel;
        ProductName = productName;
        Value = value;
    }

    public String getCreditName() {
        return CreditName;
    }

    public void setCreditName(String creditName) {
        CreditName = creditName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPesel() {
        return Pesel;
    }

    public void setPesel(String pesel) {
        Pesel = pesel;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer value) {
        Value = value;
    }
}
