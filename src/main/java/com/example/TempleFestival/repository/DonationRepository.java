package com.example.TempleFestival.repository;

import com.example.TempleFestival.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Integer>{

    List<Donation> findByMemberMemberIdAndFestivalFestivalId(int memberId,int festivalId);

    List<Donation> findByFestivalFestivalId(int festivalId);
    
}