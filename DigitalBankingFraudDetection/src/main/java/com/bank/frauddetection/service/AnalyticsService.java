package com.bank.frauddetection.service;

import com.bank.frauddetection.model.Transaction;
import com.bank.frauddetection.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private TransactionRepository transactionRepository;

    public String exportTrainingData() {

        List<Transaction> txs = transactionRepository.findAll();
        String filePath = "fraud-training-data.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            writer.append("amount,location,riskScore,status\n");

            for (Transaction tx : txs) {
                writer.append(tx.getAmount() + ",")
                        .append(tx.getLocation() + ",")
                        .append(tx.getRiskScore() + ",")
                        .append(tx.getStatus() + "\n");
            }

        } catch (Exception e) {
            throw new RuntimeException("CSV Export Failed");
        }

        return filePath;
    }
}
