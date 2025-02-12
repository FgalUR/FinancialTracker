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
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", account=" + account +
                ", category=" + category +
                '}';
    }

    public Transaction(){
    }
    public Transaction(int id, int amount, LocalDateTime date, Account account, Category category) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.category = category;
    }
}
