package com.example.TempleFestival.service;

import com.example.TempleFestival.controller.CommitteeMemberController;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.ExpenseRequestDTO;
import com.example.TempleFestival.DTO.response.ExpenseResponseDTO;
import com.example.TempleFestival.DTO.summary.ExpenseSummaryResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.ExpenseMapper;
import com.example.TempleFestival.model.Expense;
import com.example.TempleFestival.model.Event;
import com.example.TempleFestival.model.Unit;
import com.example.TempleFestival.model.ExpenseType;
import com.example.TempleFestival.model.Festival;
import com.example.TempleFestival.repository.EventRepository;
import com.example.TempleFestival.repository.ExpenseTypeRepository;

import com.example.TempleFestival.repository.ExpenseRepository;
import com.example.TempleFestival.repository.FestivalRepository;
import com.example.TempleFestival.repository.ItemRepository;
import com.example.TempleFestival.repository.UnitRepository;

@Service 
public class ExpenseService {


     @Autowired
      private ExpenseTypeRepository expenseTypeRepository;

      @Autowired 
      private EventRepository eventRepository;

      @Autowired
      private UnitRepository unitRepository;

      @Autowired
      private FestivalRepository festivalRepository;

      @Autowired
      private ExpenseRepository expenseRepository;

      @Autowired
      private ExpenseMapper expenseMapper;


      public String expenseInsert(ExpenseRequestDTO request){

        Festival festival =  festivalRepository.findById(request.getFestivalId()). 
        orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId() ));

         Event event =  eventRepository.findById(request.getEventId()). 
        orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + request.getEventId() ));

        ExpenseType expenseType =  expenseTypeRepository.findById(request.getExpenseTypeId()). 
        orElseThrow(() -> new ResourceNotFoundException("Expensetype not found with id: " + request.getExpenseTypeId() ));

         Unit unit =  unitRepository.findById(request.getUnitId()). 
        orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + request.getUnitId() ));

        Expense expense = expenseMapper.toEntity(festival,event,expenseType,unit,request);

        expenseRepository.save(expense);

        return "Expense Added Successfully...";
      }

      public List<ExpenseSummaryResponseDTO> getAllExpenseSummary(){

         List<Expense> expenses =  expenseRepository.findAll();

         Map<Integer , List<Expense>> groupedExpenses = new LinkedHashMap<>();
         
        for(Expense expense : expenses){
          
          int eventId = expense.getEvent().getEventId();

          if(!groupedExpenses.containsKey(eventId)){

            groupedExpenses.put(eventId,new ArrayList<>());

          }

          groupedExpenses.get(eventId).add(expense);

        }

         List<ExpenseSummaryResponseDTO> response = new ArrayList<>();
        

         for(List<Expense> expenseGroup : groupedExpenses.values()){

          Expense FirstExpense = expenseGroup.get(0);

          Event event = FirstExpense.getEvent();

          List<ExpenseResponseDTO> expenseList = new ArrayList<>();

          for(Expense expenseItem: expenseGroup){

            ExpenseResponseDTO expenseDto = expenseMapper.toResponse(expenseItem);

            expenseList.add(expenseDto);
          }

          double eventTotalAmount = 0;

          for(Expense expenseItem : expenseGroup){

            eventTotalAmount  = eventTotalAmount + expenseItem.getExpenseTotalAmount();

          }

          ExpenseSummaryResponseDTO summaryDto = new ExpenseSummaryResponseDTO();

          summaryDto.setEventName(event.getEventName());
          summaryDto.setFestivalName(event.getFestival().getFestivalName());
          summaryDto.setYear(event.getFestival().getFestivalYear());
          summaryDto.setExpenses(expenseList);
          summaryDto.setEventTotalAmount(eventTotalAmount);

          response.add(summaryDto);
          
         }
            
         return response;
        }
         

      public ExpenseSummaryResponseDTO getExpenseByEvent(int eventId){

      List<Expense> expenses = expenseRepository.findByEventEventId(eventId);

      if(expenses.isEmpty()){

        throw new ResourceNotFoundException("No Expense found for event id: "+eventId);

      }

      Expense FirstExpense = expenses.get(0);

      Event event = FirstExpense.getEvent();

      List<ExpenseResponseDTO> expenseList = new ArrayList<>();

      for(Expense expense : expenses){

        ExpenseResponseDTO expenseDto = expenseMapper.toResponse(expense);

        expenseList.add(expenseDto);

      }

      double eventTotalAmount = 0;

      for(Expense expense : expenses){

        eventTotalAmount = eventTotalAmount + expense.getExpenseTotalAmount();

      }

      ExpenseSummaryResponseDTO summaryDto = new ExpenseSummaryResponseDTO();

      summaryDto.setEventName(event.getEventName());
      summaryDto.setFestivalName(event.getFestival().getFestivalName());
      summaryDto.setYear(event.getFestival().getFestivalId());
      summaryDto.setExpenses(expenseList);
      summaryDto.setEventTotalAmount(eventTotalAmount);

      return summaryDto;

      }

      public String expenseUpdate(int id,ExpenseRequestDTO request){

        Expense existingExpense =  expenseRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id ));


        Festival festival = festivalRepository.findById(request.getFestivalId()). 
        orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId() ));

        Event event = eventRepository.findById(request.getEventId()). 
        orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + request.getEventId() ));

       ExpenseType expenseType = expenseTypeRepository.findById(request.getExpenseTypeId()). 
        orElseThrow(() -> new ResourceNotFoundException("ExpenseType not found with id: " + request.getExpenseTypeId() ));

       Unit  unit = unitRepository.findById(request.getUnitId()). 
        orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + request.getUnitId() ));

        Expense expense = expenseMapper.toEntityUpdate(existingExpense,festival,event,expenseType,unit,request);

        expenseRepository.save(expense);

        return "Expense Updated Successfully...";
      }

      public String expenseDeleteId(int id){

        Expense existingExpense = expenseRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        
         expenseRepository.deleteById(existingExpense.getExpenseId());

         return "Expense Id : "+ id+" Deleted Successfully...";
      }
}
