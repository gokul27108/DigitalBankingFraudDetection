package com.bank.frauddetection.controller;

import com.bank.frauddetection.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/export")
    public String exportTrainingData() {
        return analyticsService.exportTrainingData();
    }
}
