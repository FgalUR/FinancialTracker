package com.iqcorp.financialtracker.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long balance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    private List<Transaction> transactions;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", user=" + user +
                '}';
    }

    public Account(){}
    public Account(int id, String name, long balance, User user) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.user = user;
    }
}
