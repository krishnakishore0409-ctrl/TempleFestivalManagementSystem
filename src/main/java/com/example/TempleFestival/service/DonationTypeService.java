package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.DonationTypeRequestDTO;
import com.example.TempleFestival.DTO.response.DonationTypeResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.DonationTypeMapper;
import com.example.TempleFestival.model.DonationType;
import com.example.TempleFestival.repository.DonationTypeRepository;

@Service
public class DonationTypeService {
    
    @Autowired
      private DonationTypeRepository donationTypeRepository;

      @Autowired
      private DonationTypeMapper donationTypeMapper;

      public String donationTypeInsert(DonationTypeRequestDTO request){

      DonationType donationType = donationTypeMapper.toEntity(request);

       donationTypeRepository.save(donationType);

       return "DonationType Added successfully...";
      }

      public List<DonationTypeResponseDTO> donationTypeGet(){

        List<DonationType> donationType =  donationTypeRepository.findAll();

        List<DonationTypeResponseDTO> response = new ArrayList<>();

        for(DonationType d : donationType){

          DonationTypeResponseDTO dto = donationTypeMapper.toResponse(d);

          response.add(dto);
        }

        return response;
      }
        
      public DonationTypeResponseDTO donationTypeGetId(int id){

        DonationType donationType =  donationTypeRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("DonationType not found with id: " + id));

        DonationTypeResponseDTO response = donationTypeMapper.toResponse(donationType);

        return response;

      }

      public String donationTypeUpdate(int id,DonationTypeRequestDTO request){

        DonationType existingDonationType =  donationTypeRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id ));

        DonationType donationType = donationTypeMapper.toEntityUpdate(existingDonationType,request);

        donationTypeRepository.save(donationType);

        return "DonationType Updated Successfully...";
      }

      public String donationTypeDeleteId(int id){

        DonationType existingDonationType =  donationTypeRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("DonationType not found with id: " + id));

        donationTypeRepository.deleteById(existingDonationType.getDonationTypeId());

        return "DonationType Id : "+ id+" Deleted Successfully...";

      }
}
