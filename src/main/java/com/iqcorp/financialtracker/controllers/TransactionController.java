package com.iqcorp.financialtracker.controllers;

import com.iqcorp.financialtracker.models.Transaction;
import com.iqcorp.financialtracker.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {
    final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transactions")
    public void createTransaction(@RequestBody Transaction transaction) {
        transactionService.createTransaction(transaction);
    }

    @PutMapping("/transactions")
    public void updateTransaction(@RequestBody Transaction transaction) {
        transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/transactions/{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionService.deleteTransaction(id);
    }
}
