package com.payment.solution.model;

import com.payment.solution.enums.AccountType;

public class Account {

    private Long id;
    private Integer accountNumber;
    private AccountType accountType;
    private String sortCode;
    private Double currentBalance;

    public Account() {
    }

    public Account(Long id, Integer accountNumber, AccountType accountType, String sortCode, Double currentBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.sortCode = sortCode;
        this.currentBalance = currentBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
