package com.example.TempleFestival.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TempleFestival.model.DonationType;

@Repository
public interface DonationTypeRepository extends JpaRepository<DonationType,Integer>{
    
}