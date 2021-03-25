package com.ahk.program.data;

import com.google.gson.JsonObject;

public class Product {

    private int id;

    private String name;

    private float price;

    private int val;

    private String barcode;

    @Override
    public String toString() {
        return "\tProduct :\n\t{\n" +
                "\t\tid=" + id +
                ",\n\t\t\t name='" + name + '\'' +
                ",\n\t\t\t price=" + price +
                ",\n\t\t\t val=" + val +
                ",\n\t\t\t barcode='" + barcode + '\'' +
                "\n\t}";
    }

    public String toJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id",id);
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("price",price);
        jsonObject.addProperty("val",val);
        jsonObject.addProperty("barcode",barcode);
        return jsonObject.toString();
    }

    public int getId() {
        return id;
    }

    public Product id(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Product price(float price) {
        this.price = price;
        return this;
    }

    public int getVal() {
        return val;
    }

    public Product val(int val) {
        this.val = val;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public Product barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

}
