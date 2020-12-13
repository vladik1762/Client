package com.company;

public class Debt extends Operation {
    private String destination;
    private String kindOfDebt;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getKindOfDebt() {
        return kindOfDebt;
    }

    public void setKindOfDebt(String kindOfDebt) {
        this.kindOfDebt = kindOfDebt;
    }

    @Override
    public String getType() {
        return "Долг";
    }
}
