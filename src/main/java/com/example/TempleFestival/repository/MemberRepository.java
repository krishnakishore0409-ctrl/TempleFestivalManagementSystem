package com.example.TempleFestival.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TempleFestival.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
   
       // Create duplicate check
       boolean existsByMemberNo(int memberNo);

        // Update duplicate check
        boolean existsByMemberNoAndMemberIdNot(int memberNo, int memberId);
        
}
