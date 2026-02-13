package com.bank.frauddetection.controller;

import com.bank.frauddetection.model.FraudLog;
import com.bank.frauddetection.model.Transaction;
import com.bank.frauddetection.repository.FraudLogRepository;
import com.bank.frauddetection.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud")
public class FraudController {

    @Autowired
    private FraudLogRepository fraudLogRepository;

    // REST API
    @GetMapping("/logs")
    public List<FraudLog> getFraudLogs() {
        return fraudLogRepository.findAll();
    }
}
