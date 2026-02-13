package com.bank.frauddetection.ml;

import com.bank.frauddetection.model.Transaction;

public interface FraudMLPlugin {

    /**
     * Predict fraud risk using ML model
     * @return risk score (0–100)
     */
    int predictRisk(Transaction transaction);

    /**
     * Model name (for analytics)
     */
    String modelName();
}
