package com.iqcorp.financialtracker.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Getter
@Setter
@Component
@Entity
@Table(name = "budgets")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int limitAmount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", limitAmount=" + limitAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", category='" + category + '\'' +
                ", user=" + user +
                '}';
    }

    public Budget(){}

    public Budget(int id, int limitAmount, LocalDateTime startDate, LocalDateTime endDate, Category category, User user) {
        this.id = id;
        this.limitAmount = limitAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.user = user;
    }
}
