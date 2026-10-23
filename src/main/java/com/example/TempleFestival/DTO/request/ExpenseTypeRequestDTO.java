package com.example.TempleFestival.DTO.request;

import jakarta.validation.constraints.NotBlank;

public class ExpenseTypeRequestDTO {
    
    @NotBlank (message = "ExpenseType name  is required")
    private String expenseTypeName;
    
   
    public String getExpenseTypeName() {
        return expenseTypeName;
    }
    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }
    
}
