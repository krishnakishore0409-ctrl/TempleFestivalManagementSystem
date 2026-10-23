package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TempleFestival.service.DonationTypeService;
import com.example.TempleFestival.DTO.request.DonationTypeRequestDTO;
import com.example.TempleFestival.DTO.response.DonationTypeResponseDTO;
import java.util.List;
import jakarta.validation.Valid;

@RestController 
public class DonationTypeController {
      
       @Autowired 
       private DonationTypeService service;
    
        //donationType
     @PostMapping("/donationType/create")
     public String donationTypeInsert(@Valid @RequestBody DonationTypeRequestDTO request){
        return service.donationTypeInsert(request);
     }

     @GetMapping("/donationType/get")
     public List<DonationTypeResponseDTO> donationTypeGet(){
        return service.donationTypeGet();
     }

     @GetMapping("/donationType/getId/{id}")
     public DonationTypeResponseDTO donationTypeGetId(@PathVariable int id){
        return  service.donationTypeGetId(id);
     }

     @PutMapping("/donationType/update/{id}")
     public String donationTypeUpdate(@PathVariable int id , @Valid @RequestBody DonationTypeRequestDTO request){
        return service.donationTypeUpdate(id,request);
     }

     @DeleteMapping("/donationType/deleteId/{id}")
     public String donationTypeDeleteId(@PathVariable int id){
        return service.donationTypeDeleteId(id);
     }

}
