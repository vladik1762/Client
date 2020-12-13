package com.company;




public class Consumption  extends Operation{
    private String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getType() {
        return "Расход";
    }
}
