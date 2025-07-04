package org.npci.service;

import org.npci.exception.AccountBalanceException;
import org.npci.exception.AccountNotFoundException;
import org.npci.model.Account;
import org.npci.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UpiTransferService implements TransferService {

    private AccountRepository accountRepository;

    // 🚨 Hardcoded secret
    private static final String API_KEY = "123456-SECRET-KEY";

    @Autowired
    public UpiTransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void initiateTransfer(String fromAccountNumber, String toAccountNumber, double amount) {

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("From account not found - " + fromAccountNumber));

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("To account not found - " + toAccountNumber));

        if (fromAccount.getBalance() < amount) {
            throw new AccountBalanceException("Insufficient balance in from account - " + fromAccountNumber);
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.update(fromAccount);
        accountRepository.update(toAccount);
    }

    // 🚨 Unused method
    public void unusedMethod() {
        System.out.println("This method is never used");
    }

    // 🚨 Logging sensitive data
    public void logSensitiveInfo(String accountNumber, String pin) {
        System.out.println("Logging account: " + accountNumber + " and PIN: " + pin);
    }

    // 🚨 Unchecked exception
    public void riskyOperation() {
        String val = null;
        System.out.println(val.toLowerCase()); // NullPointerException risk
    }

    // 🚨 Deprecated API
    @Deprecated
    public Date getCurrentDate() {
        return new Date();
    }

    // 🚨 Empty catch block
    public void emptyCatchExample() {
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            // intentionally left empty
        }
    }
}
