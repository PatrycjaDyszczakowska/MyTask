package com.credit.app.model;

public class Credit {
    private int ID;
    private String CreditName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCreditName() {
        return CreditName;
    }

    public void setCreditName(String creditName) {
        CreditName = creditName;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "ID=" + ID +
                ", CreditName='" + CreditName + '\'' +
                '}';
    }
}
