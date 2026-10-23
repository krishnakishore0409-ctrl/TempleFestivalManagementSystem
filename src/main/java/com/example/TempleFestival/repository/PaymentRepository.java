package com.example.TempleFestival.repository;

import com.example.TempleFestival.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

List<Payment> findByMemberMemberIdAndFestivalFestivalId(int memberId,int festivalId);

    
     List<Payment> findByFestivalFestivalId(int festivalId);

     
    @Query("""
             SELECT COALESCE(SUM(p.amount), 0)
             FROM Payment p
             WHERE p.member.memberId = :memberId
             AND p.festival.festivalId = :festivalId 
             """)
      double getTotalPaid(
            @Param("memberId") int memberId,
            @Param("festivalId") int festivalId
     );

     @Query(""" 
          SELECT COUNT(DISTINCT p.member.memberId)
          FROM Payment p 
          WHERE p.festival.festivalId 
          = :festivalId
     """)
     long countMembersByFestivalId(@Param ("festivalId") int festivalId);
}