package com.example.TempleFestival.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TempleFestival.model.ExpenseType;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Integer>{

    
}