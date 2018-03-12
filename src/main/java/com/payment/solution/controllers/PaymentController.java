package com.payment.solution.controllers;

import com.payment.solution.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/rest/payments")
    public ResponseEntity makePayment() {

        return ResponseEntity.ok().body("Endpoint is alive!");
    }

    @RequestMapping("/rest/accounts")
    public ResponseEntity getAccounts() {

        return ResponseEntity.ok().body(accountRepository.findAll());
    }
}
