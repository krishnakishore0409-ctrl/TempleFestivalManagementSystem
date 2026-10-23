package com.example.TempleFestival.service;

import com.example.TempleFestival.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import  com.example.TempleFestival.model.*;
import com.example.TempleFestival.exception.DuplicateResourceException;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.exception.BadRequestException;
import com.example.TempleFestival.repository.MemberRepository;
import com.example.TempleFestival.repository.PaymentRepository;
import com.example.TempleFestival.repository.FestivalRepository;
import com.example.TempleFestival.DTO.request.PaymentRequestDTO;
import com.example.TempleFestival.DTO.response.PaymentResponseDTO;
import com.example.TempleFestival.DTO.summary.PaymentMemberSummaryResponseDTO;
import java.util.*;
import org.springframework.stereotype.Service;

@Service 
public class PaymentService {
 
    
       @Autowired
       private PaymentRepository paymentRepository;

       @Autowired
       private PaymentMapper paymentMapper;

       @Autowired 
       private MemberRepository memberRepository;

       @Autowired 
       private FestivalRepository festivalRepository;

       public String paymentInsert(PaymentRequestDTO request){

        if(request.getAmount() <= 0 ){

          throw new BadRequestException(
            "Payment amount must be greater than zero"
          );

        }

        Member member = memberRepository.findById(request.getMemberId()). 
           orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + request.getMemberId()));

           Festival festival = festivalRepository.findById(request.getFestivalId()). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId() ));

           Payment payment = paymentMapper.toEntity(request,member,festival);

           paymentRepository.save(payment);

          return "Payment Added Successfully...";
     }

       public List<PaymentMemberSummaryResponseDTO> getAllPaymentSummary(){

         List<Payment> payments = paymentRepository.findAll();

         Map<String, List<Payment>>  groupedPayment = new LinkedHashMap<>();

         for(Payment payment : payments){

          int memberId = payment.getMember().getMemberId();

          int festivalId = payment.getFestival().getFestivalId();

          String key = memberId + "-" + festivalId;

          if(!groupedPayment.containsKey(key)){

              groupedPayment.put(key, new ArrayList<>()

            );

          }
          
           groupedPayment.get(key).add(payment);

        }

         
        List<PaymentMemberSummaryResponseDTO> response = new ArrayList<>();

        for(List<Payment> paymentGroup :groupedPayment.values()){

          Payment firstPayment = paymentGroup.get(0);

          Member member = firstPayment.getMember();

          Festival festival = firstPayment.getFestival();

          List<PaymentResponseDTO> paymentList = new ArrayList<>();

          for(Payment payment : paymentGroup){

            PaymentResponseDTO paymentDto = paymentMapper.toResponse(payment);  
            
            paymentList.add(paymentDto);

          }

          double totalPaid = 0;

          for(Payment payment :paymentGroup){

            totalPaid = totalPaid + payment.getAmount();

          }

          PaymentMemberSummaryResponseDTO summaryDto = new PaymentMemberSummaryResponseDTO();

          summaryDto.setMemberName(member.getMemberName());
          summaryDto.setFestivalName(festival.getFestivalName());
          summaryDto.setPayments(paymentList);
          summaryDto.setTotalPaid(totalPaid);
          
          response.add(summaryDto);

        }

        return response;

        }
      
         public PaymentMemberSummaryResponseDTO getPaymentSummary(int memberId,int festivalId){

          Member member = memberRepository.findById(memberId).
          orElseThrow(() -> new ResourceNotFoundException("Member not found with id: "+memberId));

          Festival festival = festivalRepository.findById(festivalId). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + festivalId));

           List<Payment> payments = paymentRepository.
           findByMemberMemberIdAndFestivalFestivalId(memberId,festivalId);

           List<PaymentResponseDTO> paymentList = new ArrayList<>();

           for(Payment payment : payments){

              PaymentResponseDTO dto = paymentMapper.toResponse(payment);

              paymentList.add(dto);
           }

           double totalPaid = paymentRepository.getTotalPaid(memberId, festivalId);


           PaymentMemberSummaryResponseDTO response = new PaymentMemberSummaryResponseDTO();

           response.setMemberName(member.getMemberName());
           response.setFestivalName(festival.getFestivalName());
           response.setMemberPhone(member.getPhone());
           response.setFestivalYear(festival.getFestivalYear());
           response.setPayments(paymentList);
           response.setTotalPaid(totalPaid);

           return response;
         }


      public String paymentUpdate(int id ,PaymentRequestDTO request){

        Payment existingPayment = paymentRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id ));

        
        Member member = memberRepository.findById(request.getMemberId()). 
           orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + request.getMemberId() ));

        Festival festival = festivalRepository.findById(request.getFestivalId()). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId()));

       Payment payment = paymentMapper.toEntityUpdate(existingPayment,member,festival,request);
   
        paymentRepository.save(payment);

        return "Payment Updated Successfully...";
      }

      public String paymentDeleteId(int id){

        Payment existingPayment = paymentRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));

        paymentRepository.deleteById(existingPayment.getPaymentId());

        return "Payment Id : "+id+" Delete Successfully...";
      }    
}
