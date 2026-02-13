package com.bank.frauddetection.service;

import com.bank.frauddetection.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TransactionSimulationService {

    private static final String[] LOCATIONS = {
            "DELHI", "MUMBAI", "BANGALORE", "CHENNAI"
    };

    public List<Transaction> generateTransactions(int count) {

        List<Transaction> transactions = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {

            Transaction tx = new Transaction();
            tx.setAccountNumber("ACC" + (1000 + random.nextInt(9000)));
            tx.setLocation(LOCATIONS[random.nextInt(LOCATIONS.length)]);

            // Fraud scenario: High amount
            if (random.nextBoolean()) {
                tx.setAmount(80000 + random.nextInt(50000)); // FRAUD
            } else {
                tx.setAmount(500 + random.nextInt(5000)); // NORMAL
            }

            transactions.add(tx);
        }
        return transactions;
    }
}
