package com.product.app.model;

public class Product {
    private Integer ID;
    private Integer CreditID;
    private String ProductName;
    private Integer Value;

    public Product() {}

    public Product(Integer creditID, String productName, Integer value) {
        CreditID = creditID;
        ProductName = productName;
        Value = value;
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
