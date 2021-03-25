package com.ahk.program.data;

public class Sale {


    @Override
    public String toString() {
        return "Sale{" +
                "receiptCount=" + receiptCount +
                ", totalAmount=" + totalAmount +
                ", cashPayment=" + cashPayment +
                ", creditPayment=" + creditPayment +
                '}';
    }

    Integer receiptCount;

    Float totalAmount;

    Float cashPayment;

    Float creditPayment;


    public Integer getReceiptCount() {
        return receiptCount;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public Float getCashPayment() {
        return cashPayment;
    }

    public Float getCreditPayment() {
        return creditPayment;
    }

    public Sale receiptCount(Integer receiptCount) {
        this.receiptCount = receiptCount;
        return this;
    }

    public Sale totalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Sale cashPayment(Float cashPayment) {
        this.cashPayment = cashPayment;
        return this;
    }

    public Sale creditPayment(Float creditPayment) {
        this.creditPayment = creditPayment;
        return this;
    }

}
