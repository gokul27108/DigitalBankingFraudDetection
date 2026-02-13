package com.bank.frauddetection.repository;

import com.bank.frauddetection.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountNumberAndTransactionTimeAfter(
            String accountNumber, LocalDateTime time);

    List<Transaction> findByAccountNumber(String accountNumber);

    List<Transaction> findByStatus(String status);
}
