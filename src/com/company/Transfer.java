package com.company;

public class Transfer extends Operation {
    private String id_accountTo;



    public String getId_accountTo() {
        return id_accountTo;
    }

    public void setId_accountTo(String id_accountTo) {
        this.id_accountTo = id_accountTo;
    }

    @Override
    public String getType() {
        return "Перевод";
    }
}
