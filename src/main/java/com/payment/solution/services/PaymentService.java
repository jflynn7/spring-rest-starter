package com.payment.solution.services;

import com.payment.solution.model.PaymentRequest;
import com.payment.solution.model.PaymentSummary;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    PaymentSummary makePayment(PaymentRequest paymentRequest);
}

