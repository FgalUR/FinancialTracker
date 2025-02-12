package com.iqcorp.financialtracker.service;

import com.iqcorp.financialtracker.models.Account;
import com.iqcorp.financialtracker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(int id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public Account createAccount(Account transaction) {
        return accountRepository.save(transaction);
    }

    public Account updateAccount(Account account) {
        if (!accountRepository.existsById(account.getId())) {
            throw new RuntimeException("Transaction not found");
        }
        return accountRepository.save(account);
    }

    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }
}

