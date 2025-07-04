package org.npci.service;

import org.npci.exception.AccountBalanceException;
import org.npci.exception.AccountNotFoundException;
import org.npci.model.Account;
import org.npci.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Service
public class UpiTransferService implements TransferService {

    private static final Logger logger = LoggerFactory.getLogger(UpiTransferService.class);
    private final AccountRepository accountRepository;

    // Secure: Load from environment variable
    private static final String API_KEY = System.getenv("TRANSFER_API_KEY");

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

    // Avoid logging sensitive data
    public void logSensitiveInfo(String accountNumber, String pin) {
        logger.info("Sensitive operation triggered for account ending with {}", accountNumber.substring(accountNumber.length() - 4));
    }

    // Null-safe operation
    public void riskyOperation() {
        String val = null;
        if (val != null) {
            logger.info(val.toLowerCase());
        } else {
            logger.warn("Value is null, skipping operation");
        }
    }

    // Replaced deprecated API
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    // Log exception instead of empty catch
    public void emptyCatchExample() {
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            logger.error("Exception occurred in emptyCatchExample: {}", e.getMessage());
        }
    }
}
