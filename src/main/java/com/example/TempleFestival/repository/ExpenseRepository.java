package com.example.TempleFestival.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TempleFestival.model.Expense;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer>{
    

    List<Expense> findByEventEventId(int eventId);

    List<Expense> findByFestivalFestivalId(int festivalId);
    
}