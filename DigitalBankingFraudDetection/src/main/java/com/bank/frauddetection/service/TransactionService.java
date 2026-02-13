package com.bank.frauddetection.service;

import com.bank.frauddetection.model.FraudStatus;
import com.bank.frauddetection.model.Transaction;
import com.bank.frauddetection.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private FraudDetectionService fraudService;

    public Transaction createTransaction(Transaction tx) {

        tx.setTransactionTime(LocalDateTime.now());
        Transaction saved = transactionRepository.save(tx);

        int risk = fraudService.calculateRisk(saved);
        FraudStatus status = fraudService.detectStatus(risk);

        saved.setRiskScore(risk);
        saved.setStatus(status.name());

        return transactionRepository.save(saved);
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getFraudTransactions() {
        return transactionRepository.findByStatus("FRAUD");
    }
}
