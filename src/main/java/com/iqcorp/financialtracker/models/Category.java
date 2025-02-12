package com.iqcorp.financialtracker.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int isIncome;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isIncome=" + isIncome +
                '}';
    }

    public Category(){
    }
    public Category(int id, String name, int isIncome) {
        this.id = id;
        this.name = name;
        this.isIncome = isIncome;
    }
}
