package com.iqcorp.financialtracker.service;

import com.iqcorp.financialtracker.models.Budget;
import com.iqcorp.financialtracker.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget getBudgetById(int id) {
        return budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(Budget budget) {
        if (!budgetRepository.existsById(budget.getId())) {
            throw new RuntimeException("Budget not found");
        }
        return budgetRepository.save(budget);
    }

    public void deleteBudget(int id) {
        budgetRepository.deleteById(id);
    }
}
