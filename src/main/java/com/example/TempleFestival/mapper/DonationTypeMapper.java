package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.DonationTypeRequestDTO;
import com.example.TempleFestival.DTO.response.DonationTypeResponseDTO;
import com.example.TempleFestival.model.*;
import org.springframework.stereotype.Component;

@Component
public class DonationTypeMapper {
    
    public DonationType toEntity(DonationTypeRequestDTO request){

        DonationType donationType = new DonationType();

        donationType.setDonationTypeName(request.getDonationTypeName());

        return donationType;

    }

    public DonationTypeResponseDTO toResponse(DonationType donationType){

        DonationTypeResponseDTO response = new DonationTypeResponseDTO();

        response.setDonationTypeId(donationType.getDonationTypeId());
        response.setDonationTypeName(donationType.getDonationTypeName());

        return response;
    }

    public DonationType toEntityUpdate(DonationType existingDonationType, DonationTypeRequestDTO request){

        existingDonationType.setDonationTypeName(request.getDonationTypeName());

        return existingDonationType;
    }
}
