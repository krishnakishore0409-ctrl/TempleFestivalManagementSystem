package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TempleFestival.service.ExpenseTypeService;
import com.example.TempleFestival.DTO.request.ExpenseTypeRequestDTO;
import com.example.TempleFestival.DTO.response.ExpenseTypeResponseDTO;
import com.example.TempleFestival.model.ExpenseType;
import java.util.List;
import jakarta.validation.Valid;

@RestController 
public class ExpenseTypeController {

    @Autowired 
    private ExpenseTypeService service;
    
    //Expensetype
     @PostMapping("/expenseType/create")
     public String expenseTypeInsert(@Valid @RequestBody ExpenseTypeRequestDTO request){
        return service.expenseTypeInsert(request);
     } 

     @GetMapping("/expenseType/get")
     public List<ExpenseTypeResponseDTO> expenseTypeGet(){
        return service.expenseTypeGet();
     }

     @GetMapping("/expenseType/getId/{id}")
     public ExpenseTypeResponseDTO expenseTypeGetId(@PathVariable int id){
        return service.expenseTypeGetId(id);
     }

     @PutMapping("/expenseType/update/{id}")
     public String expenseTypeUpdate(@PathVariable int id , @Valid @RequestBody ExpenseTypeRequestDTO request){
         return service.expenseTypeUpdate(id,request);
     }

     @DeleteMapping("/expenseType/deleteId")
     public String expenseTypeDeleteId(@PathVariable int id){
        return service.expenseTypeDeleteId(id);
     }

}
