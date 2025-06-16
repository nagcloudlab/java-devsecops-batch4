package com.npci.service;

import com.npci.model.Account;
import com.npci.repository.SqlAccountRepository;

/**
 * author: blue-team
 */

public class UPITransferService {

    public UPITransferService() {
        System.out.println("UPITransferService component initialized.");
    }

    public void transfer(double amount,String source,String target){
        System.out.println("Transfer Initiated");
        SqlAccountRepository accountRepository=new SqlAccountRepository();
        // load 'source' account d details
        Account sourceAccount=accountRepository.loadAccount(source);
        // load 'taget' account details
        Account targetAccount=accountRepository.loadAccount(target);
        // check if source account has sufficient balance
        if(sourceAccount.balance < amount){
            throw new RuntimeException("Insufficient balance in source account");
        }
        // deduct amount from source account
        System.out.println("Debiting " + amount + " from source account: " + source);
        sourceAccount.balance -= amount;
        // add amount to target account
        System.out.println("Crediting " + amount + " to target account: " + target);
        targetAccount.balance += amount;
        // update source account in repository
        accountRepository.updateAccount(sourceAccount);
        // update target account in repository
        accountRepository.updateAccount(targetAccount);
        System.out.println("Transfer Successful");
    }

}
