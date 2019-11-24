package com.customer.app.model;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa zawierająca informacje o kliencie
 */
public class Customer {
    private Integer ID;
    private Integer CreditID;
    private String FirstName;
    private String Surname;
    private String Pesel;

    public Customer(){}

    public Customer(Integer creditID, String firstName, String surname, String pesel) {
        CreditID = creditID;
        FirstName = firstName;
        Surname = surname;
        Pesel = pesel;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCreditID() {
        return CreditID;
    }

    public void setCreditID(Integer creditID) {
        CreditID = creditID;
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
}

