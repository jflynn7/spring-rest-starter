package com.payment.solution.services;

import com.payment.solution.enums.PaymentStatus;
import com.payment.solution.model.Account;
import com.payment.solution.model.PaymentLog;
import com.payment.solution.model.PaymentRequest;
import com.payment.solution.model.PaymentSummary;
import com.payment.solution.repositories.AccountRepository;
import com.payment.solution.repositories.PaymentLogRepository;
import com.payment.solution.repositories.PaymentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRequestRepository paymentRequestRepository;

    @Autowired
    private PaymentLogRepository paymentLogRepository;

    @Override
    public PaymentSummary makePayment(PaymentRequest paymentRequest) {
        final Account paymentFrom = accountRepository.findAccountByAccountNumber(paymentRequest.getAccountNumberFrom());
        final Account paymentTo = accountRepository.findAccountByAccountNumber(paymentRequest.getAccountNumberTo());

        // Save the payment request first, else transient nightmares
        paymentRequest.setPaymentDate(new Date());
        paymentRequest = paymentRequestRepository.save(paymentRequest);

        if(null != paymentFrom && accountHasFunds(paymentFrom, paymentRequest.getTotalAmount())) {
            return confirmPayment(paymentFrom, paymentTo, paymentRequest);
        } else {
            return rejectPayment(paymentFrom, paymentTo, paymentRequest);
        }

    }

    /**
     * Check if account paying out has enough cleared funds to make the payment
     * @param account - Account to check for funds
     * @param paymentAmount - The amount to make sure is available
     * @return
     */
    private Boolean accountHasFunds(Account account, Double paymentAmount) {
        return account.getCurrentBalance() >= paymentAmount;
    }

    /**
     * Confirm payment and update accounts
     * @param paymentFrom - The account the payment should come from
     * @param paymentTo - The account the payment should go to
     * @param paymentRequest - The payment request from HTTP
     * @return PaymentSummary A summary of a successful payment
     */
    private PaymentSummary confirmPayment(Account paymentFrom, Account paymentTo, PaymentRequest paymentRequest) {

        final PaymentLog paymentLog = new PaymentLog();
        final PaymentSummary paymentSummary = new PaymentSummary();

        // Add/Deduct funds from relevant accounts
        paymentFrom.setCurrentBalance(paymentFrom.getCurrentBalance() - paymentRequest.getTotalAmount());
        paymentTo.setCurrentBalance(paymentTo.getCurrentBalance() + paymentRequest.getTotalAmount());

        // Set payment log details
        paymentLog.setPaymentStatus(PaymentStatus.APPROVED);
        paymentLog.setPaymentRequest(paymentRequest);

        // Save log and update accounts in database
        paymentLogRepository.save(paymentLog);
        accountRepository.save(paymentFrom);
        accountRepository.save(paymentTo);

        // Update and return payment summary
        paymentSummary.setAccountPaidFrom(paymentFrom);
        paymentSummary.setAccountPaidTo(paymentTo);
        paymentSummary.setPaymentLog(paymentLog);
        paymentSummary.setPaymentRequest(paymentRequest);

        return paymentSummary;
    }

    /**
     * Reject payment and log it!
     * @param paymentFrom - The account the payment should come from
     * @param paymentTo - The account the payment should go to
     * @param paymentRequest - The payment request from HTTP
     * @return PaymentSummary A summary of a rejected payment
     */
    private PaymentSummary rejectPayment(Account paymentFrom, Account paymentTo, PaymentRequest paymentRequest) {
        final PaymentLog paymentLog = new PaymentLog();
        final PaymentSummary paymentSummary = new PaymentSummary();

        // Set payment log details
        paymentLog.setPaymentStatus(PaymentStatus.REJECTED);
        paymentLog.setPaymentRequest(paymentRequest);

        // Save log
        paymentLogRepository.save(paymentLog);

        // Update and return payment summary
        paymentSummary.setAccountPaidFrom(paymentFrom);
        paymentSummary.setAccountPaidTo(paymentTo);
        paymentSummary.setPaymentLog(paymentLog);
        paymentSummary.setPaymentRequest(paymentRequest);

        return paymentSummary;
    }
}
