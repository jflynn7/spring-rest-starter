package com.payment.solution.repositories;

import com.payment.solution.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByAccountNumber(Integer accountNumber);
}
