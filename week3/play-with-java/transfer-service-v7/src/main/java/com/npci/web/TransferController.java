package com.npci.web;

import com.npci.dto.TransferRequest;
import com.npci.dto.TransferResponse;
import com.npci.exception.AccountBalanceException;
import com.npci.exception.AccountNotFoundException;
import com.npci.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class TransferController {

    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/v1/transfer",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> handleTransfer(
            @RequestBody TransferRequest transferRequest
            ) {
        TransferResponse transferResponse = new TransferResponse();
        try {
            transferService.initiateTransfer(
                    transferRequest.getFromAccount(),
                    transferRequest.getToAccount(),
                    transferRequest.getAmount());
            transferResponse.setStatus("success");
            transferResponse.setMessage("transfer successful");
            transferResponse.setTransactionId("12121212");

            // 200,
            return ResponseEntity.ok(transferResponse);

        } catch (AccountNotFoundException | AccountBalanceException ex) {
            // Handle exceptions and return an error view
            // You can log the exception or show an error message to the user
            //ex.printStackTrace();
            transferResponse.setStatus("error");
            transferResponse.setMessage(ex.getMessage());
            // 400 Bad Request
            return ResponseEntity.badRequest().body(transferResponse);
        }
    }

}
