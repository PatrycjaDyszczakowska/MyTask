package com.credit.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name="seq", initialValue=3)
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @NotNull
    private Integer ID;

    @NotNull
    private String CreditName;

    public Credit(){}

    public Credit(@NotNull String creditName){
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
