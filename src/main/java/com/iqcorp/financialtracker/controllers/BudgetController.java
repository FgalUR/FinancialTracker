package com.iqcorp.financialtracker.controllers;

import com.iqcorp.financialtracker.models.Budget;
import com.iqcorp.financialtracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BudgetController {
    final BudgetService budgetService;
    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/budgets")
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @GetMapping("/budgets/{id}")
    public Budget getBudgetsById(@PathVariable int id) {
        return budgetService.getBudgetById(id);
    }

    @PostMapping("/budgets")
    public void createBudget(@RequestBody Budget budget) {
        budgetService.createBudget(budget);
    }

    @PutMapping("/budgets")
    public void updateBudget(@RequestBody Budget budget) {
        budgetService.updateBudget(budget);
    }

    @DeleteMapping("/budgets/{id}")
    public void deleteBudget(@PathVariable int id) {
        budgetService.deleteBudget(id);
    }
}
