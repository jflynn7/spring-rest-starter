package com.payment.solution.repositories;

import com.payment.solution.model.PaymentRequest;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRequestRepository extends CrudRepository<PaymentRequest, Long> {
}
