package com.ahk.program.ui.util;

import javafx.beans.property.*;

public class ProductTableModel {

    private final IntegerProperty id;
    private final StringProperty name;
    private final FloatProperty price;
    private final IntegerProperty val;
    private final StringProperty barcode;

    public ProductTableModel(Integer id, String name, float price, Integer val, String barcode) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleFloatProperty(price);
        this.val = new SimpleIntegerProperty(val);
        this.barcode = new SimpleStringProperty(barcode);
    }


    public Integer getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public float getPrice() {
        return price.get();
    }

    public int getVal() {
        return val.get();
    }

    public String getBarcode() {
        return barcode.get();
    }


    public IntegerProperty getIdProperty() {
        return id;
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public FloatProperty getPriceProperty() {
        return price;
    }

    public IntegerProperty getValProperty() {
        return val;
    }

    public StringProperty getBarcodeProperty() {
        return barcode;
    }


    public ProductTableModel id(int id) {
        this.id.set(id);
        return this;
    }


    public ProductTableModel name(String name) {
        this.name.set(name);
        return this;
    }


    public ProductTableModel price(float price) {
        this.price.set(price);
        return this;
    }


    public ProductTableModel val(int val) {
        this.val.set(val);
        return this;
    }


    public ProductTableModel barcode(String barcode) {
        this.barcode.set(barcode);
        return this;
    }

}
