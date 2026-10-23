package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.PaymentRequestDTO;
import com.example.TempleFestival.DTO.response.PaymentResponseDTO;
import com.example.TempleFestival.model.*;

import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    
    public Payment toEntity(PaymentRequestDTO request,Member member,Festival festival){

        Payment payment = new Payment();

        payment.setAmount(request.getAmount());
        payment.setPaymentDate(request.getPaymentDate());
        payment.setFestival(festival);
        payment.setMember(member);

        return payment;
    }

    public PaymentResponseDTO toResponse(Payment payment){
;
    PaymentResponseDTO response = new PaymentResponseDTO();

    response.setPaymentId(payment.getPaymentId());
    response.setAmount(payment.getAmount());
    response.setPaymentDate(payment.getPaymentDate());

     return response;    

     }

   
    public Payment toEntityUpdate(Payment existingPayment, Member member,Festival festival,PaymentRequestDTO request ){

         existingPayment.setAmount(request.getAmount());
         existingPayment.setPaymentDate(request.getPaymentDate());
         existingPayment.setFestival(festival);
         existingPayment.setMember(member);

         return existingPayment;
    }
    }

