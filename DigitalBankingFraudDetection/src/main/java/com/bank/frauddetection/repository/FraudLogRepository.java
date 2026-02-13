package com.bank.frauddetection.repository;

import com.bank.frauddetection.model.FraudLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudLogRepository extends JpaRepository<FraudLog, Long> {}
