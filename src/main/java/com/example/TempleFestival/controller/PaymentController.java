package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.TempleFestival.service.MemberService;
import com.example.TempleFestival.service.PaymentService;
import java.util.List;
import com.example.TempleFestival.DTO.request.PaymentRequestDTO;
import com.example.TempleFestival.DTO.response.PaymentResponseDTO;
import com.example.TempleFestival.DTO.summary.PaymentMemberSummaryResponseDTO;

import jakarta.validation.Valid;

@RestController 
public class PaymentController {

    @Autowired
    private PaymentService service;

     //payment
      @PostMapping("/payment/create")
    public String paymentInsert(@Valid @RequestBody PaymentRequestDTO request){
        return service.paymentInsert(request);
    }

     @GetMapping("/payment/member/{memberId}/festival/{festivalId}")
     public PaymentMemberSummaryResponseDTO getPaymentSummary(@PathVariable int memberId,@PathVariable int festivalId){
      return service.getPaymentSummary(memberId,festivalId);
     }
     
     @GetMapping("payment/getAll/PaymentList")
     public List<PaymentMemberSummaryResponseDTO> getAllPaymentSummary(){
        return service.getAllPaymentSummary();
     }

     @PutMapping("/payment/update/{id}")
     public String paymentUpdate(@PathVariable int id , @Valid @RequestBody PaymentRequestDTO request){
        return service.paymentUpdate(id,request);
     }

     @DeleteMapping("/payment/deleteId/{id}")
        public String paymentDeleteId(@PathVariable int id){
            return service.paymentDeleteId(id);
        }

    
}
