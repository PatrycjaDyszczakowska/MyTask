package com.credit.app.model;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa zawierająca informacje o kredycie
 */
public class Credit {
    private Integer ID;
    private String CreditName;

    public Credit() {
    }

    public Credit(Integer ID, String creditName) {
        this.ID = ID;
        CreditName = creditName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCreditName() {
        return CreditName;
    }

    public void setCreditName(String creditName) {
        CreditName = creditName;
    }

}
