package com.example.TempleFestival.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TempleFestival.model.CommitteeMember;

@Repository 
public interface CommitteeMemberRepository extends JpaRepository<CommitteeMember,Integer>{
    
     
}