package com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.model;


public class PaymentDetails {
    private double amount;

    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getAmount(double amount) {
        return this.amount;
    }
}