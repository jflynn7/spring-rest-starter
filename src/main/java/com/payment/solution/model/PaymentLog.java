package com.payment.solution.model;

import com.payment.solution.enums.PaymentStatus;

public class PaymentLog {

    private Long id;
    private PaymentRequest paymentRequest;
    private PaymentStatus paymentStatus;

    public PaymentLog() {
    }

    public PaymentLog(Long id, PaymentRequest paymentRequest, PaymentStatus paymentStatus) {
        this.id = id;
        this.paymentRequest = paymentRequest;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
