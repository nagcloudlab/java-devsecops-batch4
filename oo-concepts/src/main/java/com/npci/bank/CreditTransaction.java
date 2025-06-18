package com.npci.bank;

public class CreditTransaction implements BankTransaction{

    @Override
    public void process() {
        //.. logic for credit transaction
    }

    @Override
    public String getDetails() {
        return "";
    }
}
