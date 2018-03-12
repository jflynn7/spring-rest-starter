package com.payment.solution.model;

import java.util.Date;

public class PaymentRequest {

    private Long id;
    private Integer accountNumberTo;
    private Integer accountNumberFrom;
    private Double totalAmount;
    private Date paymentDate;

    public PaymentRequest() {
    }

    public PaymentRequest(Long id, Integer accountNumberTo, Integer accountNumberFrom, Double totalAmount, Date paymentDate) {
        this.id = id;
        this.accountNumberTo = accountNumberTo;
        this.accountNumberFrom = accountNumberFrom;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(Integer accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    public Integer getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(Integer accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
