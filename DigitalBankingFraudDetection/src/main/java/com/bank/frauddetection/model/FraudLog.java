package com.bank.frauddetection.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FraudLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long transactionId;
    private String ruleViolated;
    private int riskScore;
    private LocalDateTime loggedAt;

    public FraudLog() {}

    public FraudLog(Long transactionId, String ruleViolated, int riskScore) {
        this.transactionId = transactionId;
        this.ruleViolated = ruleViolated;
        this.riskScore = riskScore;
        this.loggedAt = LocalDateTime.now();
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getRuleViolated() {
        return ruleViolated;
    }

    public void setRuleViolated(String ruleViolated) {
        this.ruleViolated = ruleViolated;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
