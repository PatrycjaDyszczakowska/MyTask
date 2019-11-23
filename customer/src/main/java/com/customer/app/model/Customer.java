package com.customer.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer ID;

    @NotNull
    private Integer CreditID;

    @NotNull
    private String FirstName;

    @NotNull
    private String Surname;

    @NotNull
    private String Pesel;

    public Customer(){}

    public Customer(@NotNull Integer creditID, @NotNull String firstName, @NotNull String surname, @NotNull String pesel) {
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