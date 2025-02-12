package com.iqcorp.financialtracker.repository;

import com.iqcorp.financialtracker.models.SavingGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingGoalsRepository extends JpaRepository<SavingGoals,Integer> {
}
