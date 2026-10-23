package com.example.TempleFestival.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TempleFestival.model.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Integer>{

}