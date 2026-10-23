package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.ExpenseTypeRequestDTO;
import com.example.TempleFestival.DTO.response.ExpenseTypeResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.ExpenseTypeMapper;
import com.example.TempleFestival.model.ExpenseType;
import com.example.TempleFestival.repository.ExpenseTypeRepository;

@Service 
public class ExpenseTypeService {
    

    @Autowired
      private ExpenseTypeRepository expenseTypeRepository;

      @Autowired
      private ExpenseTypeMapper expenseTypeMapper;

      public String expenseTypeInsert(ExpenseTypeRequestDTO request){

        ExpenseType expenseType = expenseTypeMapper.toEntity(request);

        expenseTypeRepository.save(expenseType);

        return "ExpenseType Added Successfully...";
      }

      public List<ExpenseTypeResponseDTO> expenseTypeGet(){

             List<ExpenseType> expenseTypes = expenseTypeRepository.findAll();

             List<ExpenseTypeResponseDTO> response = new ArrayList<>();

             for(ExpenseType e : expenseTypes){

              ExpenseTypeResponseDTO dto = expenseTypeMapper.toResponse(e);

              response.add(dto);

             }

             return response;
      }

      public ExpenseTypeResponseDTO expenseTypeGetId(int id){

         ExpenseType expenseType =  expenseTypeRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("ExpenseType not found with id: " + id));

        ExpenseTypeResponseDTO response = expenseTypeMapper.toResponse(expenseType);

         return response;
      }

      public String expenseTypeUpdate(int id,ExpenseTypeRequestDTO request){

        ExpenseType existingExpenseType =  expenseTypeRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Expensetype not found with id: " + id ));

         ExpenseType expenseType = expenseTypeMapper.toEntityUpdate(existingExpenseType,request);

         expenseTypeRepository.save(expenseType);

         return "ExpenseType Updated Successfully...";
      }

      public String expenseTypeDeleteId(int id){

        ExpenseType existingExpenseType =  expenseTypeRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("ExpenseType not found with id: " + id));

         expenseTypeRepository.deleteById(existingExpenseType.getExpenseTypeId());

         return "ExpenseType Id :"+id+" Deleted Successfully...";
         
      }
}
