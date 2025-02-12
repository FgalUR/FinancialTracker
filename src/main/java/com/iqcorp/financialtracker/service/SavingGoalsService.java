package com.iqcorp.financialtracker.service;

import com.iqcorp.financialtracker.models.SavingGoals;
import com.iqcorp.financialtracker.repository.SavingGoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingGoalsService {
    private final SavingGoalsRepository savingGoalsRepository;

    @Autowired
    public SavingGoalsService(SavingGoalsRepository savingGoalsRepository) {
        this.savingGoalsRepository = savingGoalsRepository;
    }

    public List<SavingGoals> getAllSavingGoals() {
        return savingGoalsRepository.findAll();
    }

    public SavingGoals getSavingGoalsById(int id) {
        return savingGoalsRepository.findById(id).orElseThrow(() -> new RuntimeException("SavingGoals not found"));
    }

    public SavingGoals createSavingGoals(SavingGoals savingGoals) {
        return savingGoalsRepository.save(savingGoals);
    }

    public SavingGoals updateSavingGoals(SavingGoals savingGoals) {
        if (!savingGoalsRepository.existsById(savingGoals.getId())) {
            throw new RuntimeException("SavingGoals not found");
        }
        return savingGoalsRepository.save(savingGoals);
    }

    public void deleteSavingGoals(int id) {
        savingGoalsRepository.deleteById(id);
    }
}
