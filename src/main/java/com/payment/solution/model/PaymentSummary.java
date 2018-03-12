package com.payment.solution.model;

public class PaymentSummary {
    private Account accountPaidFrom;
    private Account accountPaidTo;
    private PaymentLog paymentLog;
    private PaymentRequest paymentRequest;

    public PaymentSummary() {
    }

    public PaymentSummary(Account accountPaidFrom, Account accountPaidTo, PaymentLog paymentLog, PaymentRequest paymentRequest) {
        this.accountPaidFrom = accountPaidFrom;
        this.accountPaidTo = accountPaidTo;
        this.paymentLog = paymentLog;
        this.paymentRequest = paymentRequest;
    }

    public Account getAccountPaidFrom() {
        return accountPaidFrom;
    }

    public void setAccountPaidFrom(Account accountPaidFrom) {
        this.accountPaidFrom = accountPaidFrom;
    }

    public Account getAccountPaidTo() {
        return accountPaidTo;
    }

    public void setAccountPaidTo(Account accountPaidTo) {
        this.accountPaidTo = accountPaidTo;
    }

    public PaymentLog getPaymentLog() {
        return paymentLog;
    }

    public void setPaymentLog(PaymentLog paymentLog) {
        this.paymentLog = paymentLog;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }
}
