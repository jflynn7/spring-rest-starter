package com.payment.solution.repositories;

import com.payment.solution.model.PaymentLog;
import org.springframework.data.repository.CrudRepository;

public interface PaymentLogRepository extends CrudRepository<PaymentLog, Long> {
}
