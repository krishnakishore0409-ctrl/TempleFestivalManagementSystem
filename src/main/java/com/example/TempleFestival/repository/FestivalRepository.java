package com.example.TempleFestival.repository;

import com.example.TempleFestival.model.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.TempleFestival.model.Donation;
import com.example.TempleFestival.model.Payment;

@Repository
public interface FestivalRepository extends JpaRepository<Festival,Integer>{

     List<Payment> findByFestivalId(int festivalId);
}