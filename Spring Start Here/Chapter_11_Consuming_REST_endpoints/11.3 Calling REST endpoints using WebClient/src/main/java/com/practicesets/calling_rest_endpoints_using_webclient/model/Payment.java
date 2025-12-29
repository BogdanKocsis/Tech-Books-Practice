package com.practicesets.calling_rest_endpoints_using_webclient.model;

public class Payment {
    private String requestId;
    private double amount;

    public void setId(String requestId) {
        this.requestId = requestId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRequestId() {
        return this.requestId;

    }

    public double getAmount() {
        return this.amount;
    }
}