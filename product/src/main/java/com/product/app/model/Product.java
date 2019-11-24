package com.product.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name="seq", initialValue=3)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @NotNull
    private Integer ID;

    @NotNull
    private Integer CreditID;

    @NotNull
    private String ProductName;

    @NotNull
    private Integer Value;

    public Product() {}

    public Product(@NotNull Integer creditID, @NotNull String productName, @NotNull Integer value) {
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
