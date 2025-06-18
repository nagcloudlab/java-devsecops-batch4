package com.npci.bank;

public class TransferTransaction implements BankTransaction{
    @Override
    public void process() {
        // logic for transfer transaction
    }

    @Override
    public String getDetails() {
        return "";
    }
}
