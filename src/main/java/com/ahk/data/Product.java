package com.ahk.data;

public class Product {

    private int id;

    private String name;

    private float price;

    private int val;

    private String barcode;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", val=" + val +
                ", barcode='" + barcode + '\'' +
                '}';
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
