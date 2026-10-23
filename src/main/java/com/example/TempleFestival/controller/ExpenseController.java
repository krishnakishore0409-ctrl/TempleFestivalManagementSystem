package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TempleFestival.service.ExpenseService;
import com.example.TempleFestival.DTO.request.ExpenseRequestDTO;
import com.example.TempleFestival.DTO.response.ExpenseResponseDTO;
import com.example.TempleFestival.DTO.summary.ExpenseSummaryResponseDTO;

import java.util.List;
import jakarta.validation.Valid;

@RestController 
public class ExpenseController {
 
    @Autowired 
    private ExpenseService service;

    //Expense
     @PostMapping("/expense/create")
     public String expenseInsert(@Valid @RequestBody ExpenseRequestDTO request){
        return service.expenseInsert(request);
     } 

     @GetMapping("/expense/get")
     public List<ExpenseSummaryResponseDTO> getAllExpenseSummary(){
        return service.getAllExpenseSummary();
     }

     @GetMapping("/expense/{eventId}")
     public ExpenseSummaryResponseDTO getExpenseByEvent(@PathVariable int eventId){
        return service.getExpenseByEvent(eventId);
     }

     @PutMapping("/expense/update/{id}")
     public String expenseUpdate(@PathVariable int id , @Valid @RequestBody ExpenseRequestDTO request){
         return service.expenseUpdate(id,request);
     }

     @DeleteMapping("/expense/deleteId")
     public String expenseDeleteId(@PathVariable int id){
        return service.expenseDeleteId(id);
     }

}
