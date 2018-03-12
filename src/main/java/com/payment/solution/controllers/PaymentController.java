package com.payment.solution.controllers;
import com.payment.solution.model.PaymentRequest;
import com.payment.solution.repositories.AccountRepository;

import com.payment.solution.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/rest/payments")
    public ResponseEntity requestPayment(@RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok().body(paymentService.makePayment(paymentRequest));
    }

    @RequestMapping("/rest/accounts")
    public ResponseEntity getAccounts() {

        return ResponseEntity.ok().body(accountRepository.findAll());
    }

}
