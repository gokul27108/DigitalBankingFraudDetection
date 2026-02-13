package com.bank.frauddetection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.frauddetection.model.Transaction;
import com.bank.frauddetection.service.TransactionService;

@Controller
public class DashboardController {

    @Autowired
    private TransactionService transactionService;

    // Dashboard
    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("transactions",
                transactionService.getAll());
        return "dashboard";
    }

    @PostMapping("/transaction/create")
    public String createTransaction(
            @ModelAttribute Transaction transaction) {

        transactionService.createTransaction(transaction);
        return "redirect:/";
    }

    @GetMapping("/fraud-report")
    public String fraudReport(Model model) {
        model.addAttribute("transactions",
                transactionService.getFraudTransactions());
        return "fraud-report";
    }
}
