package com.npci.model;

public enum TransactionType {
    CREDIT("credit"),
    DEBIT("debit"),
    TRANSFER("transfer");

    private final String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
