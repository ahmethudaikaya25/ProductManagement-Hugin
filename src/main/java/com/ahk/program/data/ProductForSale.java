package com.ahk.program.data;

import com.google.gson.JsonObject;

public class ProductForSale {


    private String name;

    private float price;

    private int val;

    public String toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("rice", price);
        jsonObject.addProperty("val", val);
        return jsonObject.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


}
