package com.example.TempleFestival.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TempleFestival.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer>{
    
}