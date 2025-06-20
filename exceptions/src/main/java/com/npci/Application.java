package com.npci;


/*

    2 types Throwable

        - Exception ( CheckedException )
            - RuntimeException ( UnCheckedException )
        - Error

 */


class AccountNotFoundException extends RuntimeException {
    private String accountId;

    public AccountNotFoundException(String accountId) {
        this.accountId = accountId;
    }

    public String getMessage() {
        return "Account with id " + accountId + " not found";
    }
}

class AccountBalanceException extends RuntimeException {
    private String accountId;
    private double balance;

    public AccountBalanceException(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getMessage() {
        return "Balance of account " + accountId + " is " + balance;
    }
}

//------------------------------------------------
// Service / Business Layer - processing logic  ( upi-team )
//------------------------------------------------

class TransferService {

    public void transfer(String from, String to, double amount) {
        // Load 'from' & 'to' account details
        boolean isFromAccountExist = !from.equals("999");
        if (!isFromAccountExist) {
            //throw new IllegalArgumentException("Account " + from + " does not exist");
            throw new AccountNotFoundException(from);
        }
        double fromAccountBalance = 1000.00;
        if (fromAccountBalance < amount) {
            //throw IllegalStateException("no enough balance");
            throw new AccountBalanceException(from, fromAccountBalance);
        }

    }
}

//------------------------------------------------
// Web / Api   - request & response logic ( upi-team )
//------------------------------------------------

class TransferController {

    TransferService transferService = new TransferService();

    // POST /api/transfer
    public void handleTransfer(String from, String to, double amount) {
        try {
            transferService.transfer(from, to, amount);
            System.out.println("Transfer successful");
        } catch (AccountNotFoundException | AccountBalanceException e) {
            // log it  ( log4j | sl4j )...
            // provide friendly error messages to user
            System.out.println("Ex-" + e.getMessage());
            // execute Plan-B
            // re-throw
            // clean external connectivity..
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}


public class Application {
    public static void main(String[] args) {

        // Spring Framework
        TransferController transferController = new TransferController();
        transferController.handleTransfer("1", "2", 10000.00);

    }
}
