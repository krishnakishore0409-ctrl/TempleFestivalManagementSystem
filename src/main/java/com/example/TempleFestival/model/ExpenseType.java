package com.example.TempleFestival.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.*;


@Entity
public class ExpenseType{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseTypeId;
    private String expenseTypeName;

    @OneToMany(mappedBy = "expenseType")
    private List<Expense> expense;

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getExpenseTypeName() {
        return expenseTypeName;
    }

    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }

    
}