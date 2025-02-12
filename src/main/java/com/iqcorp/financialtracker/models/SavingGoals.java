package com.iqcorp.financialtracker.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
@Entity
@Table(name = "saving_goals")
public class SavingGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int targetAmount;
    private int currentAmount;
    private LocalDateTime deadline;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public String toString() {
        return "SavingGoals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", targetAmount=" + targetAmount +
                ", currentAmount=" + currentAmount +
                ", deadline=" + deadline +
                ", user=" + user +
                '}';
    }

    public SavingGoals() {
    }

    public SavingGoals(int id, String name, int targetAmount, int currentAmount, LocalDateTime deadline, User user) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.deadline = deadline;
        this.user = user;
    }
}
