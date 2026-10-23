package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.TempleFestival.service.DonationService;
import java.util.List;
import com.example.TempleFestival.DTO.request.DonationRequestDTO;
// import com.example.TempleFestival.DTO.response.DonationResponseDTO;
import com.example.TempleFestival.DTO.summary.DonationFestivalSummaryResponseDTO;
import com.example.TempleFestival.DTO.summary.DonationTotalItemSummaryResponseDTO;
import jakarta.validation.Valid;


@RestController
public class DonationController {
    
   @Autowired 
   private DonationService service;

    //donation
     @PostMapping("/donation/create")
     public String donationInsert(@Valid @RequestBody DonationRequestDTO request){
        return service.donationInsert(request);
     }

     @GetMapping("/donation/get")
     public List<DonationFestivalSummaryResponseDTO> donationGet(){
        return service.donationGet();
     }

     @GetMapping("/donation/member/{memberId}/festival/{festivalId}")
     public DonationFestivalSummaryResponseDTO donationGetId(@PathVariable int memberId,@PathVariable int festivalId){
        return  service.donationGetId(memberId,festivalId);
     }

     @GetMapping("/donation/TotalDonationList/festival/{festivalId}")
     public  DonationTotalItemSummaryResponseDTO donationList(@PathVariable  int  festivalId) {
         return service.donationListGetFestivalId(festivalId);
     }
     

     @PutMapping("/donation/update/{id}")
     public String donationUpdate(@PathVariable int id , @Valid @RequestBody DonationRequestDTO request){
        return service.donationUpdate(id,request);
     }

     @DeleteMapping("/donation/deleteId/{id}")
     public String donationDeleteId(@PathVariable int id){
        return service.donationDeleteId(id);
     }

}
