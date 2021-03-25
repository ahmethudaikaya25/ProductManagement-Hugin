package com.ahk.program.data;

public class SaleDetails {


    Integer productId;

    String productName;

    Float amount;


    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Float getAmount() {
        return amount;
    }

    public SaleDetails productId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public SaleDetails productName(String productName) {
        this.productName = productName;
        return this;
    }

    public SaleDetails amount(Float amount) {
        this.amount = amount;
        return this;
    }
}
