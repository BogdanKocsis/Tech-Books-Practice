package com.practicesets.calling_rest_endpoints_using_resttemplate.model;

public class Payment {
    private String id;
    private double amount;

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getId() {
        return this.id;

    }

    public double getAmount() {
        return this.amount;
    }
}