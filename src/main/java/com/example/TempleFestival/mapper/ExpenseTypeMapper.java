package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.ExpenseTypeRequestDTO;
import com.example.TempleFestival.DTO.response.ExpenseTypeResponseDTO;
import com.example.TempleFestival.model.*;
import org.springframework.stereotype.Component;


@Component
public class ExpenseTypeMapper{
 
    public ExpenseType toEntity(ExpenseTypeRequestDTO request){

        ExpenseType expenseType = new ExpenseType();

        expenseType.setExpenseTypeName(request.getExpenseTypeName());
        
        return expenseType;

    }

    public ExpenseTypeResponseDTO toResponse(ExpenseType expenseType){

        ExpenseTypeResponseDTO response = new ExpenseTypeResponseDTO();

        response.setExpenseTypeId(expenseType.getExpenseTypeId());
        response.setExpenseTypeName(expenseType.getExpenseTypeName());

        return response;
    }

    public ExpenseType toEntityUpdate(ExpenseType existingExpenseType,ExpenseTypeRequestDTO request){

        
        existingExpenseType.setExpenseTypeName(request.getExpenseTypeName());

        return existingExpenseType;
        
    }
    
}
