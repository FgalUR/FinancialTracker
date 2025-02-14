package com.iqcorp.financialtracker.controllers;

import com.iqcorp.financialtracker.models.SavingGoals;
import com.iqcorp.financialtracker.service.SavingGoalsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SavingGoalsControllers {
    final SavingGoalsService savingGoalsService;

    public SavingGoalsControllers(SavingGoalsService savingGoalsService) {
        this.savingGoalsService = savingGoalsService;
    }

    @GetMapping("/savingGoals")
    public List<SavingGoals> getAllCategories() {
        return savingGoalsService.getAllSavingGoals();
    }

    @GetMapping("/savingGoals/{id}")
    public SavingGoals getSavingGoalsById(@PathVariable int id) {
        return savingGoalsService.getSavingGoalsById(id);
    }

    @PostMapping("/savingGoals")
    public void createSavingGoals(@RequestBody SavingGoals savingGoals) {
        savingGoalsService.createSavingGoals(savingGoals);
    }

    @PutMapping("/savingGoals")
    public void updateSavingGoals(@RequestBody SavingGoals savingGoals) {
        savingGoalsService.updateSavingGoals(savingGoals);
    }

    @DeleteMapping("/savingGoals/{id}")
    public void deleteSavingGoals(@PathVariable int id) {
        savingGoalsService.deleteSavingGoals(id);
    }
}
