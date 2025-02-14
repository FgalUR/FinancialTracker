package com.iqcorp.financialtracker.controllers;

import com.iqcorp.financialtracker.models.Account;
import com.iqcorp.financialtracker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/accounts")
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PutMapping("/accounts")
    public void updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
    }
}
