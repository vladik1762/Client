package com.company;

public class Income extends Operation{
    private String payer;

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    @Override
    public String getType() {
        return "Доход";
    }
}
