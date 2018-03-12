package com.payment.solution.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @RequestMapping("/rest/payments")
    public ResponseEntity makePayment() {

        return ResponseEntity.ok().body("Endpoint is alive!");
    }
}
