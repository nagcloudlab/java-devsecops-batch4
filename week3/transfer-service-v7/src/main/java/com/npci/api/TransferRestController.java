package com.npci.api;

import com.npci.dto.TransferRequest;
import com.npci.exception.AccountBalanceException;
import com.npci.exception.AccountNotFoundException;
import com.npci.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
public class TransferRestController {

    private final TransferService transferService;

    @Autowired
    public TransferRestController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest request) {
        try {
            String result = transferService.initiateTransfer(
                    request.getFromAccount(),
                    request.getToAccount(),
                    request.getAmount());
            return ResponseEntity.ok(result);
        } catch (AccountNotFoundException | AccountBalanceException ex) {
            return ResponseEntity.badRequest().body("Transfer failed: " + ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Server error: " + ex.getMessage());
        }
    }
}
