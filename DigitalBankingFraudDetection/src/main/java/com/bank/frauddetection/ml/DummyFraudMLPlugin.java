package com.bank.frauddetection.ml;

import com.bank.frauddetection.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class DummyFraudMLPlugin implements FraudMLPlugin {

    @Override
    public int predictRisk(Transaction tx) {

        int risk = 0;

        if (tx.getAmount() > 60000) risk += 40;
        if ("UNKNOWN".equalsIgnoreCase(tx.getLocation())) risk += 30;

        return Math.min(risk, 100);
    }

    @Override
    public String modelName() {
        return "Dummy-Rule-ML-Model-v1";
    }
}
