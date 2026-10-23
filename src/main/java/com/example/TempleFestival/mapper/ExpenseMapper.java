package com.example.TempleFestival.mapper;


import org.springframework.stereotype.Component;

import com.example.TempleFestival.DTO.request.ExpenseRequestDTO;
import com.example.TempleFestival.DTO.response.ExpenseResponseDTO;
import com.example.TempleFestival.model.*;


@Component
public class ExpenseMapper {
    
    public Expense toEntity(Festival festival,Event event, ExpenseType expenseType, Unit unit,ExpenseRequestDTO request){

      Expense expense = new Expense();

      expense.setExpenseName(request.getExpenseName());
      expense.setExpensePurchaseDate(request.getPurchaseDate());
      expense.setExpenseQuantity(request.getQuantity());
      expense.setExpenseTotalAmount(request.getTotalAmount());
      expense.setExpenseUnitPrice(request.getUnitPrice());
      expense.setFestival(festival);
      expense.setEvent(event);
      expense.setExpenseType(expenseType);
      expense.setUnit(unit);

      return expense;

    }

    public ExpenseResponseDTO toResponse(Expense expense){

        ExpenseResponseDTO response = new ExpenseResponseDTO();

        response.setExpenseId(expense.getExpenseId());
        response.setPurchaseDate(expense.getExpensePurchaseDate());
        response.setQuantity(expense.getExpenseQuantity());
        response.setTotalAmount(expense.getExpenseTotalAmount());
        response.setUnitPrice(expense.getExpenseUnitPrice());
        response.setExpenseTypeName(expense.getExpenseType().getExpenseTypeName());
        response.setUnitName(response.getUnitName());

        return response;

    }

    public Expense toEntityUpdate(Expense existingExpense,Festival festival,Event event,ExpenseType expenseType,Unit unit,ExpenseRequestDTO request){

       existingExpense.setExpenseName(request.getExpenseName());
       existingExpense.setExpensePurchaseDate(request.getPurchaseDate());
       existingExpense.setExpensePurchaseDate(request.getPurchaseDate());
       existingExpense.setExpenseQuantity(request.getQuantity());
       existingExpense.setExpenseTotalAmount(request.getTotalAmount());
       existingExpense.setExpenseUnitPrice(request.getUnitPrice());
       existingExpense.setFestival(festival);
       existingExpense.setEvent(event);
       existingExpense.setExpenseType(expenseType);
       existingExpense.setUnit(unit);

        return existingExpense;

    }

}
